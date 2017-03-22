package com.ctp.model.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Entity
@Table(name="t_book_list")
public class TBookList {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String fid;
    @Column(name="fuser_id")
    private String fuserID;
    @Column(name="fbook_id")
    private String fbookID;

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

    public String getFbookID() {
        return fbookID;
    }

    public void setFbookID(String fbookID) {
        this.fbookID = fbookID;
    }
}
