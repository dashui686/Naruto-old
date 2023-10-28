package com.dashui.naruto.service;

import com.dashui.naruto.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.naruto.domain.vo.WxUserVo;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-29 18:22:49
*/
public interface UserService extends IService<User> {


    boolean updateUser(WxUserVo wxUserVo);

}
