package com.ctp.model.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Entity
@Table(name="t_user_list")
public class TUserList {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String fid;
    @Column(name="fuser_id")
    private String fuserID;
    @Column(name="ffriend_id")
    private String ffriendID;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFuserID() {
        return fuserID;
    }

    public void setFuserID(String fuserID) {
        this.fuserID = fuserID;
    }

    public String getFfriendID() {
        return ffriendID;
    }

    public void setFfriendID(String ffriendID) {
        this.ffriendID = ffriendID;
    }
}
