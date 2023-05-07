package com.dashui.naruto.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 附件表
 * @TableName system_attachment
 */
@TableName(value ="system_attachment")
@Data
public class SystemAttachment implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 细目
     */
    @TableField(value = "topic")
    private String topic;

    /**
     * 上传管理员ID
     */
    @TableField(value = "admin_id")
    private Integer adminId;

    /**
     * 上传用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 物理路径
     */
    @TableField(value = "url")
    private String url;

    /**
     * 宽度
     */
    @TableField(value = "width")
    private Integer width;

    /**
     * 高度
     */
    @TableField(value = "height")
    private Integer height;

    /**
     * 原始名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 大小
     */
    @TableField(value = "size")
    private Integer size;

    /**
     * mime类型
     */
    @TableField(value = "mime_type")
    private String mimeType;

    /**
     * 上传(引用)次数
     */
    @TableField(value = "quote")
    private Integer quote;

    /**
     * 存储方式
     */
    @TableField(value = "storage")
    private String storage;

    /**
     * sha1编码
     */
    @TableField(value = "sha1")
    private String sha1;

    /**
     * 上传时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 最后上传时间
     */
    @TableField(value = "last_upload_time")
    private LocalDateTime lastUploadTime;

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
        SystemAttachment other = (SystemAttachment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getMimeType() == null ? other.getMimeType() == null : this.getMimeType().equals(other.getMimeType()))
            && (this.getQuote() == null ? other.getQuote() == null : this.getQuote().equals(other.getQuote()))
            && (this.getStorage() == null ? other.getStorage() == null : this.getStorage().equals(other.getStorage()))
            && (this.getSha1() == null ? other.getSha1() == null : this.getSha1().equals(other.getSha1()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUploadTime() == null ? other.getLastUploadTime() == null : this.getLastUploadTime().equals(other.getLastUploadTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getMimeType() == null) ? 0 : getMimeType().hashCode());
        result = prime * result + ((getQuote() == null) ? 0 : getQuote().hashCode());
        result = prime * result + ((getStorage() == null) ? 0 : getStorage().hashCode());
        result = prime * result + ((getSha1() == null) ? 0 : getSha1().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUploadTime() == null) ? 0 : getLastUploadTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", topic=").append(topic);
        sb.append(", adminId=").append(adminId);
        sb.append(", userId=").append(userId);
        sb.append(", url=").append(url);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", name=").append(name);
        sb.append(", size=").append(size);
        sb.append(", mimeType=").append(mimeType);
        sb.append(", quote=").append(quote);
        sb.append(", storage=").append(storage);
        sb.append(", sha1=").append(sha1);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUploadTime=").append(lastUploadTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}