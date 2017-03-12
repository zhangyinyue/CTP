package com.ctp.model.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by zyy on 2017/3/12 0012.
 */
@Entity
@Table(name="t_book")
public class TBook {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String fid;
    private String fname;
    private byte[] fimage;
    private  String fauthor;
    private String fpublish;
    private long fpublishyear;
    private BigDecimal fscore;
    private long fcreatedate;

    public void setFcreatedate(long fcreatedate) {
        this.fcreatedate = fcreatedate;
    }

    public long getFcreatedate() {
        return fcreatedate;
    }

    public byte[] getFimage() {
        return fimage;
    }

    public String getFauthor() {
        return fauthor;
    }

    public String getFpublish() {
        return fpublish;
    }

    public long getFpublishyear() {
        return fpublishyear;
    }

    public BigDecimal getFscore() {
        return fscore;
    }

    public void setFimage(byte[] fimage) {
        this.fimage = fimage;
    }

    public void setFauthor(String fauthor) {
        this.fauthor = fauthor;
    }

    public void setFpublish(String fpublish) {
        this.fpublish = fpublish;
    }

    public void setFpublishyear(long fpublishyear) {
        this.fpublishyear = fpublishyear;
    }

    public void setFscore(BigDecimal fscore) {
        this.fscore = fscore;
    }

    public String getFid() {
        return fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
