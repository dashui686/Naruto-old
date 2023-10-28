package com.dashui.naruto.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.User;
import com.dashui.naruto.domain.vo.WxUserVo;
import com.dashui.naruto.service.UserService;
import com.dashui.naruto.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-29 18:22:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public boolean updateUser(WxUserVo wxUserVo) {
        User user = new User();
        BeanUtil.copyProperties(wxUserVo,user);
        return this.updateById(user);
    }
}




