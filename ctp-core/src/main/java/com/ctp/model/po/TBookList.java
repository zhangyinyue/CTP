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
    private long fuserID;
    @Column(name="fbook_id")
    private long fbookID;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public long getFuserID() {
        return fuserID;
    }

    public void setFuserID(long fuserID) {
        this.fuserID = fuserID;
    }

    public long getFbookID() {
        return fbookID;
    }

    public void setFbookID(long fbookID) {
        this.fbookID = fbookID;
    }
}
