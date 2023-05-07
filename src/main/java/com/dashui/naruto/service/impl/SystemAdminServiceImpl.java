package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.SystemAdmin;
import com.dashui.naruto.service.SystemAdminService;
import com.dashui.naruto.mapper.SystemAdminMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【system_admin(管理员表)】的数据库操作Service实现
* @createDate 2023-04-25 17:35:28
*/
@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin>
    implements SystemAdminService{

}




