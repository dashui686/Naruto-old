package com.dashui.naruto.service;

import cn.hutool.core.bean.BeanUtil;
import com.dashui.naruto.domain.Blogs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.naruto.domain.BlogsContent;
import com.dashui.naruto.domain.BlogsTagsMapping;
import com.dashui.naruto.domain.BlogsTypeMapping;
import com.dashui.naruto.domain.dto.BlogsDto;

import java.util.List;

/**
* @author Administrator
* @description 针对表【blogs(博客表)】的数据库操作Service
* @createDate 2023-04-12 21:38:49
*/

public interface BlogsService extends IService<Blogs> {



    boolean save(BlogsDto blogsDto);
}
