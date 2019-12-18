package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

/**
 *博文内容实体类
 */

public class TBlog {
    @Id
    @GeneratedValue
    private String id;
    @Column
    private String bwbt;
    @Column
    private String userid;
    @Column
    private String content;
    @Column
    private String zyid;
    @Column
    private String wzbq;
    @Column
    private String sfsm;
    @Column
    private String bwfl;
    @Column
    private String wzfl;
    @Column
    private Date  dtime;

    public TBlog(String bwbt, String userid, String content, String zyid, String wzbq, String sfsm, String bwfl, String wzfl, Date dtime) {
        this.bwbt = bwbt;
        this.userid = userid;
        this.content = content;
        this.zyid = zyid;
        this.wzbq = wzbq;
        this.sfsm = sfsm;
        this.bwfl = bwfl;
        this.wzfl = wzfl;
        this.dtime = dtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBwbt() {
        return bwbt;
    }

    public void setBwbt(String bwbt) {
        this.bwbt = bwbt;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getZyid() {
        return zyid;
    }

    public void setZyid(String zyid) {
        this.zyid = zyid;
    }

    public String getWzbq() {
        return wzbq;
    }

    public void setWzbq(String wzbq) {
        this.wzbq = wzbq;
    }

    public String getSfsm() {
        return sfsm;
    }

    public void setSfsm(String sfsm) {
        this.sfsm = sfsm;
    }

    public String getBwfl() {
        return bwfl;
    }

    public void setBwfl(String bwfl) {
        this.bwfl = bwfl;
    }

    public String getWzfl() {
        return wzfl;
    }

    public void setWzfl(String wzfl) {
        this.wzfl = wzfl;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }
}
