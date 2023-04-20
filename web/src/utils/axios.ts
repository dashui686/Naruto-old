import axios from 'axios'
import type { AxiosRequestConfig, AxiosPromise, Method } from 'axios'
import { ElLoading, LoadingOptions, ElNotification } from 'element-plus'
import { useConfig } from '@/stores/config'
import { isAdminApp } from '@/utils/common'
import router from '@/router/index'
import { refreshToken } from '@/api/common'
import { useUserInfo } from '@/stores/userInfo'
import { useAdminInfo } from '@/stores/adminInfo'
// import { i18n } from '@/lang/index'

// getList  获取集合
// insert   添加
// delete   删除
// update   更新
// getByid  查看



window.requests = []
window.tokenRefreshing = false
const pendingMap = new Map()
const loadingInstance: LoadingInstance = {
    target: null,
    count: 0,
}

/*
 * 根据运行环境获取基础请求URL
 */
export const getUrl = (): string => {
    const value: string = import.meta.env.VITE_AXIOS_BASE_URL as string
    return value == 'getCurrentDomain' ? window.location.protocol + '//' + window.location.host : value
}

/*
 * 根据运行环境获取基础请求URL的端口
 */
export const getUrlPort = (): string => {
    const url = getUrl()
    return new URL(url).port
}

/*
 * 创建Axios
 * 默认开启`reductDataFormat(简洁响应)`,返回类型为`ApiPromise`
 * 关闭`reductDataFormat`,返回类型则为`AxiosPromise`
 * 
 * 针对返回类型 TablePromise 只能为简洁响应才生效
 */
function createAxios(axiosConfig: AxiosRequestConfig, options: Options = {}, loading: LoadingOptions = {}): ApiPromise | AxiosPromise | TablePromise {
    const config = useConfig()
    const adminInfo = useAdminInfo()
    const userInfo = useUserInfo()

    const Axios = axios.create({
        baseURL: getUrl(),
        timeout: 1000 * 10,
        headers: {
            server: true,
        },
        responseType: 'json',
    })

    // Object.assign 合并对象  var obj = Object.assign(target,source)  // obj == target == true 
    options = Object.assign(
        {
            CancelDuplicateRequest: true, // 是否开启取消重复请求, 默认为 true
            loading: false, // 是否开启loading层效果, 默认为false
            reductDataFormat: true, // 是否开启简洁的数据结构响应, 默认为true
            showErrorMessage: true, // 是否开启接口错误信息展示,默认为true
            showCodeMessage: true, // 是否开启code不为1时的信息提示, 默认为true
            showSuccessMessage: false, // 是否开启code为1时的信息提示, 默认为false
            anotherToken: '', // 当前请求使用另外的用户token
        },
        options
    )

    // 请求拦截
    Axios.interceptors.request.use(
        (config) => {
            removePending(config)
            options.CancelDuplicateRequest && addPending(config)
            // 创建loading实例
            if (options.loading) {
                loadingInstance.count++
                if (loadingInstance.count === 1) {
                    loadingInstance.target = ElLoading.service(loading)
                }
            }

            // 自动携带token
            if (config.headers) {
                const token = adminInfo.getToken()
                if (token) (config.headers as anyObj).batoken = token
                const userToken = options.anotherToken || userInfo.getToken()
                if (userToken) (config.headers as anyObj)['ba-user-token'] = userToken
            }

            return config
        },
        (error) => {
            return Promise.reject(error)
        }
    )

    // 响应拦截
    Axios.interceptors.response.use(
        (response) => {
            removePending(response.config)
            options.loading && closeLoading(options) // 关闭loading
            if (response.config.responseType == 'json') {
                if (response.data && response.data.code !== 200) {
                    if (response.data.code == 409) {
                        if (!window.tokenRefreshing) {
                            window.tokenRefreshing = true
                            return refreshToken()
                                .then((res) => {
                                    if (res.data.type == 'admin-refresh') {
                                        adminInfo.setToken(res.data.token, 'token')
                                        response.headers.batoken = `${res.data.token}`
                                        window.requests.forEach((cb) => cb(res.data.token, 'admin-refresh'))
                                    } else if (res.data.type == 'user-refresh') {
                                        userInfo.setToken(res.data.token, 'token')
                                        response.headers['ba-user-token'] = `${res.data.token}`
                                        window.requests.forEach((cb) => cb(res.data.token, 'user-refresh'))
                                    }
                                    window.requests = []
                                    return Axios(response.config)
                                })
                                .catch((err) => {
                                    if (isAdminApp()) {
                                        adminInfo.removeToken()
                                        if (router.currentRoute.value.name != 'adminLogin') {
                                            router.push({ name: 'adminLogin' })
                                            return Promise.reject(err)
                                        } else {
                                            response.headers.batoken = ''
                                            window.requests.forEach((cb) => cb('', 'admin-refresh'))
                                            window.requests = []
                                            return Axios(response.config)
                                        }
                                    } else {
                                        userInfo.removeToken()
                                        if (router.currentRoute.value.name != 'userLogin') {
                                            router.push({ name: 'userLogin' })
                                            return Promise.reject(err)
                                        } else {
                                            response.headers['ba-user-token'] = ''
                                            window.requests.forEach((cb) => cb('', 'user-refresh'))
                                            window.requests = []
                                            return Axios(response.config)
                                        }
                                    }
                                })
                                .finally(() => {
                                    window.tokenRefreshing = false
                                })
                        } else {
                            return new Promise((resolve) => {
                                // 用函数形式将 resolve 存入，等待刷新后再执行
                                window.requests.push((token: string, type: string) => {
                                    if (type == 'admin-refresh') {
                                        response.headers.batoken = `${token}`
                                    } else {
                                        response.headers['ba-user-token'] = `${token}`
                                    }
                                    resolve(Axios(response.config))
                                })
                            })
                        }
                    }
                    if (options.showCodeMessage) {
                        ElNotification({
                            type: 'error',
                            message: response.data.msg,
                        })
                    }
                    // 自动跳转到路由name或path，仅限server端返回302的情况
                    if (response.data.code == 302) {
                        if (isAdminApp()) {
                            adminInfo.removeToken()
                        } else {
                            userInfo.removeToken()
                        }
                        if (response.data.data.routeName) {
                            router.push({ name: response.data.data.routeName })
                        } else if (response.data.data.routePath) {
                            router.push({ path: response.data.data.routePath })
                        }
                    }
                    // code不等于200, 页面then内的具体逻辑就不执行了
                    return Promise.reject(response.data)
                } else if (options.showSuccessMessage && response.data && response.data.code == 200) {
                    ElNotification({
                        message: response.data.msg ? response.data.msg : "操作成功",//i18n.global.t('axios.Operation successful'),
                        type: 'success',
                    })
                }
            }

            return options.reductDataFormat ? response.data : response
        },
        (error) => {
            error.config && removePending(error.config)
            options.loading && closeLoading(options) // 关闭loading
            options.showErrorMessage && httpErrorStatusHandle(error) // 处理错误状态码
            return Promise.reject(error) // 错误继续返回给到具体页面
        }
    )
    return options.reductDataFormat ? (Axios(axiosConfig) as ApiPromise) : (Axios(axiosConfig) as AxiosPromise)
}

export default createAxios

/**
 * 处理异常
 * @param {*} error
 */
function httpErrorStatusHandle(error: any) {
    // 处理被取消的请求
    if (axios.isCancel(error)) return ElNotification({message: "请勿重复提交数据" ,type: 'error',})
    let message = ''
    if (error && error.response) {
        switch (error.response.status) {
            case 302:
                // message = i18n.global.t('axios.Interface redirected!')
                message = "接口重定向了！"
                break
            case 400:
                message = "参数不正确！"
                // message = i18n.global.t('axios.Incorrect parameter!')
                break
            default:
                // message = i18n.global.t('axios.Abnormal problem, please contact the website administrator!')
                message = "异常问题，请联系网站管理员！"
                break
        }
    }
    if (error.message.includes('timeout')) message = '网络请求超时！'   //i18n.global.t('axios.Network request timeout!')
    if (error.message.includes('Network'))
        message = window.navigator.onLine ? '服务端异常！'  : '您断网了！'
        // message = window.navigator.onLine ? '服务端异常！' i18n.global.t('axios.Server exception!') : i18n.global.t('axios.You are disconnected!')

    ElNotification({
        type: 'error',
        message,
    })
}

/**
 * 关闭Loading层实例
 */
function closeLoading(options: Options) {
    if (options.loading && loadingInstance.count > 0) loadingInstance.count--
    if (loadingInstance.count === 0) {
        loadingInstance.target.close()
        loadingInstance.target = null
    }
}

/**
 * 储存每个请求的唯一cancel回调, 以此为标识
 */
function addPending(config: AxiosRequestConfig) {
    const pendingKey = getPendingKey(config)
    config.cancelToken =
        config.cancelToken ||
        new axios.CancelToken((cancel) => {
            if (!pendingMap.has(pendingKey)) {
                pendingMap.set(pendingKey, cancel)
            }
        })
}

/**
 * 删除重复的请求
 */
function removePending(config: AxiosRequestConfig) {
    const pendingKey = getPendingKey(config)
    if (pendingMap.has(pendingKey)) {
        const cancelToken = pendingMap.get(pendingKey)
        cancelToken(pendingKey)
        pendingMap.delete(pendingKey)
    }
}

/**
 * 生成每个请求的唯一key
 */
function getPendingKey(config: AxiosRequestConfig) {
    let { data } = config
    const { url, method, params, headers } = config
    if (typeof data === 'string') data = JSON.parse(data) // response里面返回的config.data是个字符串对象
    return [
        url,
        method,
        headers && (headers as anyObj).batoken ? (headers as anyObj).batoken : '',
        headers && (headers as anyObj)['ba-user-token'] ? (headers as anyObj)['ba-user-token'] : '',
        JSON.stringify(params),
        JSON.stringify(data),
    ].join('&')
}

/**
 * 根据请求方法组装请求数据/参数
 */
export function requestPayload(method: Method, data: anyObj) {
    if (method == 'GET') {
        return {
            params: data,
        }
    } else if (method == 'POST') {
        return {
            data: data,
        }
    }
}

interface LoadingInstance {
    target: any
    count: number
}
interface Options {
    // 是否开启取消重复请求, 默认为 true
    CancelDuplicateRequest?: boolean
    // 是否开启loading层效果, 默认为false
    loading?: boolean
    // 是否开启简洁的数据结构响应, 默认为true
    reductDataFormat?: boolean
    // 是否开启接口错误信息展示,默认为true
    showErrorMessage?: boolean
    // 是否开启code不为0时的信息提示, 默认为true
    showCodeMessage?: boolean
    // 是否开启code为0时的信息提示, 默认为false
    showSuccessMessage?: boolean
    // 当前请求使用另外的用户token
    anotherToken?: string
}

/*
 * 感谢掘金@橙某人提供的思路和分享
 * 本axios封装详细解释请参考：https://juejin.cn/post/6968630178163458084?share_token=7831c9e0-bea0-469e-8028-b587e13681a8#heading-27
 */
