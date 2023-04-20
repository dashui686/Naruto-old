import createAxios from '@/utils/axios'
import { useAdminInfo } from '@/stores/adminInfo'

const controllerUrl = '/admin/system/role'

export function getRoleList(): TablePromise{
    return createAxios({
        url: controllerUrl + '/list',
        method: 'get',
    }) as TablePromise;
}


export function insertRole(data:any):ApiPromise{
    return createAxios({
        url:controllerUrl,
        method:"post",
        data,
    }) as ApiPromise
}

export function updateRole(data:any):ApiPromise{
    return createAxios({
        url:controllerUrl,
        method:"put",
        data
    }) as ApiPromise
}

export function deleteRole(id:any):ApiPromise{
    return createAxios({
        url:controllerUrl+'?id='+id,
        method:"delete",
    }) as ApiPromise
}


export function getById(id:any):ApiPromise{
    return createAxios({
        url:controllerUrl+'/'+id,
        method:"get",
    }) as ApiPromise
}
