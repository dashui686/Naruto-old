package com.dashui.naruto.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 会员积分变动表
 * @TableName user_score_log
 */
@TableName(value ="user_score_log")
@Data
public class UserScoreLog implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会员ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 变更积分
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 变更前积分
     */
    @TableField(value = "before")
    private Integer before;

    /**
     * 变更后积分
     */
    @TableField(value = "after")
    private Integer after;

    /**
     * 备注
     */
    @TableField(value = "memo")
    private String memo;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;

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
        UserScoreLog other = (UserScoreLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getBefore() == null ? other.getBefore() == null : this.getBefore().equals(other.getBefore()))
            && (this.getAfter() == null ? other.getAfter() == null : this.getAfter().equals(other.getAfter()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getBefore() == null) ? 0 : getBefore().hashCode());
        result = prime * result + ((getAfter() == null) ? 0 : getAfter().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", score=").append(score);
        sb.append(", before=").append(before);
        sb.append(", after=").append(after);
        sb.append(", memo=").append(memo);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}