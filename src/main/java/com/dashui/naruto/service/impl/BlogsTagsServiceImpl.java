package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsTags;
import com.dashui.naruto.service.BlogsTagsService;
import com.dashui.naruto.mapper.BlogsTagsMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_tags(博客标签表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsTagsServiceImpl extends ServiceImpl<BlogsTagsMapper, BlogsTags>
    implements BlogsTagsService{

}




