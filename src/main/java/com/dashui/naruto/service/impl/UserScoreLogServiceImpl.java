package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.UserScoreLog;
import com.dashui.naruto.service.UserScoreLogService;
import com.dashui.naruto.mapper.UserScoreLogMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【user_score_log(会员积分变动表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class UserScoreLogServiceImpl extends ServiceImpl<UserScoreLogMapper, UserScoreLog>
    implements UserScoreLogService{

}




