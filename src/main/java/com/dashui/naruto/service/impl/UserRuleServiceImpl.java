package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.UserRule;
import com.dashui.naruto.service.UserRuleService;
import com.dashui.naruto.mapper.UserRuleMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【user_rule(会员权限规则表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class UserRuleServiceImpl extends ServiceImpl<UserRuleMapper, UserRule>
    implements UserRuleService{

}




