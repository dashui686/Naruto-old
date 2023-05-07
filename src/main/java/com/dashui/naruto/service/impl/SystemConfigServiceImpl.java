package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.SystemConfig;
import com.dashui.naruto.service.SystemConfigService;
import com.dashui.naruto.mapper.SystemConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【system_config(系统配置)】的数据库操作Service实现
* @createDate 2023-04-24 17:20:32
*/
@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig>
    implements SystemConfigService{

}




