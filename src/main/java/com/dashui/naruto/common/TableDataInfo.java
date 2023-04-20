package com.dashui.naruto.common;

import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/8 1:11
 * @PackageName: com.dashui.naruto.common
 * @ClassName: TableDataInfo
 * @Description: TODO
 * @Version 1.0
 */

@Data
@NoArgsConstructor
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, long total) {
        this.rows = list;
        this.total = total;
    }

    public static TableDataInfo build(IPage<?> page) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.HTTP_OK);
        rspData.setMsg("查询成功");
        rspData.setRows(page.getRecords());
        rspData.setTotal(page.getTotal());
        return rspData;
    }

    public static  TableDataInfo build(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.HTTP_OK);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(list.size());
        return rspData;
    }

    public static TableDataInfo build() {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.HTTP_OK);
        rspData.setMsg("查询成功");
        return rspData;
    }

}