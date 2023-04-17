package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsTypeMapping;
import com.dashui.naruto.service.BlogsTypeMappingService;
import com.dashui.naruto.mapper.BlogsTypeMappingMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_type_mapping(博客类型映射表)】的数据库操作Service实现
* @createDate 2023-04-16 01:04:35
*/
@Service
public class BlogsTypeMappingServiceImpl extends ServiceImpl<BlogsTypeMappingMapper, BlogsTypeMapping>
    implements BlogsTypeMappingService{

}




