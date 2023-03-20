package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.AdminGroupAccess;
import com.dashui.naruto.service.AdminGroupAccessService;
import com.dashui.naruto.mapper.AdminGroupAccessMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【admin_group_access(管理权限分组表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class AdminGroupAccessServiceImpl extends ServiceImpl<AdminGroupAccessMapper, AdminGroupAccess>
    implements AdminGroupAccessService{

}




