package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.User;
import com.dashui.naruto.service.UserService;
import com.dashui.naruto.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【user(会员表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




