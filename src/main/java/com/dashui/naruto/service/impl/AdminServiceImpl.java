package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.Admin;
import com.dashui.naruto.service.AdminService;
import com.dashui.naruto.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【admin(管理员表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




