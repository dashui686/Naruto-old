import createAxios from '@/utils/axios'
import { useUserInfo } from '@/stores/userInfo'
import { AnyARecord } from 'dns'

const controllerUrl = '/'

export function index() :ApiPromise {
    return createAxios({
        url: controllerUrl + 'index',
        method: 'get',
    }) as ApiPromise
}


export function blogs(data:anyObj) :TablePromise {
    return createAxios({
        url: controllerUrl + 'index/blogs',
        method: 'get',
        data
    }) as TablePromise
}


export function blog(blogId:any) :ApiPromise {
    return createAxios({
        url: controllerUrl + 'index/blog/'+blogId,
        method: 'get',
    }) as ApiPromise
}
