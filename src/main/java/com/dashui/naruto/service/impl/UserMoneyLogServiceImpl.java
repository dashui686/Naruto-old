package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.UserMoneyLog;
import com.dashui.naruto.service.UserMoneyLogService;
import com.dashui.naruto.mapper.UserMoneyLogMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【user_money_log(会员余额变动表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class UserMoneyLogServiceImpl extends ServiceImpl<UserMoneyLogMapper, UserMoneyLog>
    implements UserMoneyLogService{

}




