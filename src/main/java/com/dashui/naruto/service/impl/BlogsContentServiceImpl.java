package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsContent;
import com.dashui.naruto.service.BlogsContentService;
import com.dashui.naruto.mapper.BlogsContentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_content(博客内容)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsContentServiceImpl extends ServiceImpl<BlogsContentMapper, BlogsContent>
    implements BlogsContentService{

}




