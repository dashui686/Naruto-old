import createAxios from '@/utils/axios'

export function dashboard():ApiPromise {
    return createAxios({
        url: '/admin/Dashboard/dashboard',
        method: 'get',
    }) as ApiPromise
}
