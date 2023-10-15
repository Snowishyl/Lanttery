package io.snowishyl.lanttery.infrastructure.po;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
/**
 * 奖品配置(Award)表实体类
 *
 * @author makejava
 * @since 2023-10-14 12:52:33
 */
@SuppressWarnings("serial")@Entity

public class Award implements Serializable {
    //自增ID
    @Id
    private Long id;

    //奖品ID
    private String awardid;
    //奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
    private Integer awardtype;
    //奖品名称
    private String awardname;
    //奖品内容「文字描述、Key、码」
    private String awardcontent;
    //创建时间
    private Date createtime;
    //更新时间
    private Date updatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAwardid() {
        return awardid;
    }

    public void setAwardid(String awardid) {
        this.awardid = awardid;
    }

    public Integer getAwardtype() {
        return awardtype;
    }

    public void setAwardtype(Integer awardtype) {
        this.awardtype = awardtype;
    }

    public String getAwardname() {
        return awardname;
    }

    public void setAwardname(String awardname) {
        this.awardname = awardname;
    }

    public String getAwardcontent() {
        return awardcontent;
    }

    public void setAwardcontent(String awardcontent) {
        this.awardcontent = awardcontent;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}

