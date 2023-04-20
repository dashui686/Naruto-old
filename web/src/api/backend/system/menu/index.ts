import createAxios from '@/utils/axios'
import { useAdminInfo } from '@/stores/adminInfo'

const controllerUrl = '/admin/system/menu'

export function getMenuList(): TablePromise{
    return createAxios({
        url: controllerUrl + '/list',
        method: 'get',
    }) as TablePromise;
}


export function insertMenu(data:any):ApiPromise{
    return createAxios({
        url:controllerUrl,
        method:"post",
        data,
    }) as ApiPromise
}

export function updateMenu(data:any):ApiPromise{
    return createAxios({
        url:controllerUrl,
        method:"put",
        data
    }) as ApiPromise
}

export function deleteMenu(id:any):ApiPromise{
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

export function getTreeMenuList(): ApiPromise{
    return createAxios({
        url: controllerUrl + '/treeList',
        method: 'get',
    }) as ApiPromise;
}

