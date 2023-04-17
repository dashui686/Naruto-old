package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsTagsMapping;
import com.dashui.naruto.service.BlogsTagsMappingService;
import com.dashui.naruto.mapper.BlogsTagsMappingMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_tags_mapping(博客标签映射表)】的数据库操作Service实现
* @createDate 2023-04-16 01:04:35
*/
@Service
public class BlogsTagsMappingServiceImpl extends ServiceImpl<BlogsTagsMappingMapper, BlogsTagsMapping>
    implements BlogsTagsMappingService{

}




