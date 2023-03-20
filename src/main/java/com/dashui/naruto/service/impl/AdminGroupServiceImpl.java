package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.AdminGroup;
import com.dashui.naruto.service.AdminGroupService;
import com.dashui.naruto.mapper.AdminGroupMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【admin_group(管理分组表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class AdminGroupServiceImpl extends ServiceImpl<AdminGroupMapper, AdminGroup>
    implements AdminGroupService{

}




