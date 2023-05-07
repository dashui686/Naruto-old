import createAxios from '@/utils/axios'
import { isAdminApp, checkFileMimetype } from '@/utils/common'
import { getUrl } from '@/utils/axios'
import { useAdminInfo } from '@/stores/adminInfo'
import { useUserInfo } from '@/stores/userInfo'
import { ElNotification, UploadRawFile } from 'element-plus'
import { useSiteConfig } from '@/stores/siteConfig'
// import { state as uploadExpandState, fileUpload as uploadExpand } from '@/components/mixins/baUpload'


/*
 * 公共请求函数和Url定义
 */

// Admin模块
export const adminUploadUrl = '/admin/ajax/upload'
export const adminBuildSuffixSvgUrl = '/admin/ajax/buildSuffixSvg'
export const adminAreaUrl = '/admin/ajax/area'
export const getTablePkUrl = '/admin/ajax/getTablePk'
export const getTableFieldListUrl = '/admin/ajax/getTableFieldList'
export const clearCacheUrl = '/admin/ajax/clearCache'

// 公共
export const captchaUrl = '/api/common/captcha'
export const refreshTokenUrl = '/api/common/refreshToken'

// api模块(前台)
export const apiUploadUrl = '/api/ajax/upload'
export const apiBuildSuffixSvgUrl = '/api/ajax/buildSuffixSvg'
export const apiAreaUrl = '/api/ajax/area'
export const apiSendSms = '/api/Sms/send'
export const apiSendEms = '/api/Ems/send'

/**
 * 上传文件
 */
export function fileUpload(fd: FormData, params: anyObj = {}, forceLocal = false): ApiPromise {
    let errorMsg = ''
    const file = fd.get('file') as UploadRawFile
    const siteConfig = useSiteConfig()

    if (!file.name || typeof file.size == 'undefined') {
        // errorMsg = i18n.global.t('utils.The data of the uploaded file is incomplete!')
        errorMsg = '上传文件的资料不完整！'
    } else if (!checkFileMimetype(file.name, file.type)) {
        // errorMsg = i18n.global.t('utils.The type of uploaded file is not allowed!')
        errorMsg = '上传文件的类型不被允许！'
    } else if (file.size > siteConfig.upload.maxSize) {
        // errorMsg = i18n.global.t('utils.The size of the uploaded file exceeds the allowed range!')
        errorMsg = '上传文件的大小超出允许范围！'
    }
    if (errorMsg) {
        return new Promise((resolve, reject) => {
            ElNotification({
                type: 'error',
                message: errorMsg,
            })
            reject(errorMsg)
        })
    }

    // if (!forceLocal && uploadExpandState() == 'enable') {
    //     return uploadExpand(fd, params)
    // }

    return createAxios({
        url: isAdminApp() ? adminUploadUrl : apiUploadUrl,
        method: 'POST',
        data: fd,
        params: params,
        timeout: 0,
    }) as ApiPromise
}


/**
 * 发送短信
 */
export function sendSms(mobile: string, templateCode: string, extend: anyObj = {}) {
    return createAxios(
        {
            url: apiSendSms,
            method: 'POST',
            data: {
                mobile: mobile,
                template_code: templateCode,
                ...extend,
            },
        },
        {
            showSuccessMessage: true,
        }
    ) as ApiPromise
}

/**
 * 发送邮件
 */
export function sendEms(email: string, event: string, extend: anyObj = {}) {
    return createAxios(
        {
            url: apiSendEms,
            method: 'POST',
            data: {
                email: email,
                event: event,
                ...extend,
            },
        },
        {
            showSuccessMessage: true,
        }
    ) as ApiPromise
}

/*
 * 缓存清理接口
 */
export function postClearCache(type: string) {
    return createAxios(
        {
            url: clearCacheUrl,
            method: 'POST',
            data: {
                type: type,
            },
        },
        {
            showSuccessMessage: true,
        }
    )
}


export function refreshToken(): ApiPromise {
    const adminInfo = useAdminInfo()
    const userInfo = useUserInfo()
    return createAxios({
        url: refreshTokenUrl,
        method: 'POST',
        data: {
            refresh_token: isAdminApp() ? adminInfo.getToken('refresh') : userInfo.getToken('refresh'),
        },
    }) as ApiPromise
}
