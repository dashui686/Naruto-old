package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.SystemAdminLog;
import com.dashui.naruto.service.SystemAdminLogService;
import com.dashui.naruto.mapper.SystemAdminLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【system_admin_log(管理员日志表)】的数据库操作Service实现
* @createDate 2023-04-24 17:20:32
*/
@Service
public class SystemAdminLogServiceImpl extends ServiceImpl<SystemAdminLogMapper, SystemAdminLog>
    implements SystemAdminLogService{

}




