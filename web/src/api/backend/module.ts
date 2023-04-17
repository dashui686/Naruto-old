import createAxios from '/@/utils/axios'
import { useSiteConfig } from '/@/stores/siteConfig'
import { useBaAccount } from '/@/stores/baAccount'

const userControllerUrl = '/api/user/'
const captchaUrl = '/api/common/captcha'
// const moduleControllerUrl = '/admin/module/'
// const storeUrl = '/api/v4.store/'

/* 
export function modules(params: anyObj = {}) {
    const siteConfig = useSiteConfig()
    return createAxios({
        url: siteConfig.apiUrl + storeUrl + 'modules',
        method: 'get',
        params: params,
    })
} 

export function info(params: anyObj) {
    const baAccount = useBaAccount()
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + storeUrl + 'info',
            method: 'get',
            params: params,
        },
        {
            anotherToken: baAccount.getToken('auth'),
        }
    )
}
*/
export function postLogout(): ApiPromise {
    const siteConfig = useSiteConfig()
    const baAccount = useBaAccount()
    return createAxios({
        url: siteConfig.apiUrl + userControllerUrl + 'logout',
        method: 'POST',
        data: {
            refresh_token: baAccount.getToken('refresh'),
        },
    }) as ApiPromise
}

export function buildCaptchaUrl() {
    const siteConfig = useSiteConfig()
    return siteConfig.apiUrl + captchaUrl + '?server=1'
}
/* 


export function checkIn(method: 'get' | 'post', params: object = {}): ApiPromise {
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + userControllerUrl + 'checkIn',
            data: params,
            method: method,
        },
        {
            showSuccessMessage: true,
        }
    ) as ApiPromise
}

export function getUserInfo(): ApiPromise {
    const baAccount = useBaAccount()
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + userControllerUrl + 'info',
            method: 'get',
        },
        {
            anotherToken: baAccount.getToken('auth'),
        }
    ) as ApiPromise
}

export function createOrder(params: object = {}): ApiPromise {
    const baAccount = useBaAccount()
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + storeUrl + 'order',
            method: 'post',
            params: params,
        },
        {
            anotherToken: baAccount.getToken('auth'),
        }
    ) as ApiPromise
}

export function payOrder(orderId: number, payType: string): ApiPromise {
    const baAccount = useBaAccount()
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + storeUrl + 'pay',
            method: 'post',
            params: {
                order_id: orderId,
                pay_type: payType,
            },
        },
        {
            anotherToken: baAccount.getToken('auth'),
            showSuccessMessage: true,
        }
    ) as ApiPromise
}

export function payCheck(sn: string): ApiPromise {
    const baAccount = useBaAccount()
    const siteConfig = useSiteConfig()
    return createAxios(
        {
            url: siteConfig.apiUrl + '/api/pay/check',
            method: 'get',
            params: {
                sn: sn,
            },
        },
        {
            anotherToken: baAccount.getToken('auth'),
            showCodeMessage: false,
        }
    ) as ApiPromise
}


 */