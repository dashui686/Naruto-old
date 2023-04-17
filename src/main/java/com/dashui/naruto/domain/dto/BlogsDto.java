package com.dashui.naruto.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dashui.naruto.domain.BlogsTagsMapping;
import com.dashui.naruto.domain.BlogsTypeMapping;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/16 0:58
 * @PackageName: com.dashui.naruto.domain.dto
 * @ClassName: BlogsDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class BlogsDto {




    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 摘要
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 置顶
     */
    private Integer top;

    /**
     * 点赞
     */
    private Integer praise;

    /**
     * 浏览
     */
    private Integer browse;

    /**
     * 禁止观看
     */
    private Integer disable;


    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private List<BlogsTypeMapping> type;

    /**
     * 标签
     */
    private List<BlogsTagsMapping> tag;
}
