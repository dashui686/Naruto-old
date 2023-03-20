package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.AdminLog;
import com.dashui.naruto.service.AdminLogService;
import com.dashui.naruto.mapper.AdminLogMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【admin_log(管理员日志表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class AdminLogServiceImpl extends ServiceImpl<AdminLogMapper, AdminLog>
    implements AdminLogService{

}




