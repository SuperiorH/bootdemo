package com.example.demo.jpa.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
//@Entity(name = "use_buyer_collect")
@Entity
public class UseBuyerCollect {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
    private String id;
    private String userId;
    private String collectId;
    private Integer collectType;
    private Date createTime;
    private Date updateTime;
    private Boolean deleted = Boolean.FALSE;

    public UseBuyerCollect(String userId, String collectId, Integer collectType, Date createTime, Date updateTime) {
        this.userId = userId;
        this.collectId = collectId;
        this.collectType = collectType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UseBuyerCollect() {
    }
}
