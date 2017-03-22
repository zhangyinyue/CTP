package com.ctp.model.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Entity
@Table(name="t_book_review")
public class TBookReview {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String fid;
    @Column(name="fuser_id")
    private String fuserID;
    @Column(name="fbook_id")
    private String fbookID;
    private String fdesc;
    private String fscore;
    private long fdate;

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

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public String getFscore() {
        return fscore;
    }

    public void setFscore(String fscore) {
        this.fscore = fscore;
    }

    public long getFdate() {
        return fdate;
    }

    public void setFdate(long fdate) {
        this.fdate = fdate;
    }
}
