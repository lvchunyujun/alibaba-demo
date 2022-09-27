package com.hexiaofei.pubapi.entity;

import java.util.Date;

public class Employees {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String fname;

    /**
     *
     */
    private String lname;

    /**
     *
     */
    private Date hired;

    /**
     *
     */
    private Date separated;

    /**
     *
     */
    private Integer job_code;

    /**
     *
     */
    private Integer store_id;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     */
    public String getFname() {
        return fname;
    }

    /**
     *
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     *
     */
    public String getLname() {
        return lname;
    }

    /**
     *
     */
    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    /**
     *
     */
    public Date getHired() {
        return hired;
    }

    /**
     *
     */
    public void setHired(Date hired) {
        this.hired = hired;
    }

    /**
     *
     */
    public Date getSeparated() {
        return separated;
    }

    /**
     *
     */
    public void setSeparated(Date separated) {
        this.separated = separated;
    }

    /**
     *
     */
    public Integer getJob_code() {
        return job_code;
    }

    /**
     *
     */
    public void setJob_code(Integer job_code) {
        this.job_code = job_code;
    }

    /**
     *
     */
    public Integer getStore_id() {
        return store_id;
    }

    /**
     *
     */
    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }
}