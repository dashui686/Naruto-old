package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.BlogsType;
import com.dashui.naruto.service.BlogsTypeService;
import com.dashui.naruto.mapper.BlogsTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_type(博客类型表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsTypeServiceImpl extends ServiceImpl<BlogsTypeMapper, BlogsType>
    implements BlogsTypeService{

}




