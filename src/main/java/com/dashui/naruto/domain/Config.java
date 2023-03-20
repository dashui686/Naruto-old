package com.dashui.naruto.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 系统配置
 * @TableName config
 */
@TableName(value ="config")
@Data
public class Config implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 变量名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分组
     */
    @TableField(value = "group")
    private String group;

    /**
     * 变量标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 变量描述
     */
    @TableField(value = "tip")
    private String tip;

    /**
     * 类型:string,number,radio,checkbox,switch,textarea,array,datetime,date,select,selects
     */
    @TableField(value = "type")
    private String type;

    /**
     * 变量值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 字典数据
     */
    @TableField(value = "content")
    private String content;

    /**
     * 验证规则
     */
    @TableField(value = "rule")
    private String rule;

    /**
     * 扩展属性
     */
    @TableField(value = "extend")
    private String extend;

    /**
     * 允许删除:0=否,1=是
     */
    @TableField(value = "allow_del")
    private Integer allowDel;

    /**
     * 权重
     */
    @TableField(value = "weigh")
    private Integer weigh;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Config other = (Config) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGroup() == null ? other.getGroup() == null : this.getGroup().equals(other.getGroup()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTip() == null ? other.getTip() == null : this.getTip().equals(other.getTip()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getRule() == null ? other.getRule() == null : this.getRule().equals(other.getRule()))
            && (this.getExtend() == null ? other.getExtend() == null : this.getExtend().equals(other.getExtend()))
            && (this.getAllowDel() == null ? other.getAllowDel() == null : this.getAllowDel().equals(other.getAllowDel()))
            && (this.getWeigh() == null ? other.getWeigh() == null : this.getWeigh().equals(other.getWeigh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGroup() == null) ? 0 : getGroup().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTip() == null) ? 0 : getTip().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
        result = prime * result + ((getExtend() == null) ? 0 : getExtend().hashCode());
        result = prime * result + ((getAllowDel() == null) ? 0 : getAllowDel().hashCode());
        result = prime * result + ((getWeigh() == null) ? 0 : getWeigh().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", group=").append(group);
        sb.append(", title=").append(title);
        sb.append(", tip=").append(tip);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", content=").append(content);
        sb.append(", rule=").append(rule);
        sb.append(", extend=").append(extend);
        sb.append(", allowDel=").append(allowDel);
        sb.append(", weigh=").append(weigh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}