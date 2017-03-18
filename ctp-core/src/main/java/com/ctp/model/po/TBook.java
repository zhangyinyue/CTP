package com.ctp.model.po;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
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
    @Column(name="fimage", columnDefinition="BLOB", nullable=true)
    private byte[] fimage;
    @Column(name="fcontent", columnDefinition="BLOB", nullable=true)
    private byte[] fcontent;
    @Transient
    private CommonsMultipartFile imagefile;
    @Transient
    private CommonsMultipartFile file;
    private  String fauthor;
    private String fpublish;
    private long fpublishyear;
    @Transient
    private String fpublishyearstr;
    private BigDecimal fscore;
    private long fcreatedate;
    private String fdesc;

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

    public byte[] getFcontent() {
        return fcontent;
    }

    public void setFcontent(byte[] fcontent) {
        this.fcontent = fcontent;
    }

    public CommonsMultipartFile getImagefile() {
        return imagefile;
    }

    public void setImagefile(CommonsMultipartFile imagefile) {
        this.imagefile = imagefile;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public String getFpublishyearstr() {
        return fpublishyearstr;
    }

    public void setFpublishyearstr(String fpublishyearstr) {
        this.fpublishyearstr = fpublishyearstr;
    }

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
