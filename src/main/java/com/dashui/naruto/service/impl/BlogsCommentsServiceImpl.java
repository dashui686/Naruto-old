package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsComments;
import com.dashui.naruto.service.BlogsCommentsService;
import com.dashui.naruto.mapper.BlogsCommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_comments(评论表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsCommentsServiceImpl extends ServiceImpl<BlogsCommentsMapper, BlogsComments>
    implements BlogsCommentsService{

}




