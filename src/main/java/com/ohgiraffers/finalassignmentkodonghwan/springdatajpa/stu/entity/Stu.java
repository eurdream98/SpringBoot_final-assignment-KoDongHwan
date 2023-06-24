package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_stu")
public class Stu {
    @Id
    @Column(name="stu_code")
    private int stuCode;

    @Column(name="stu_name")
    private String stuName;
    @Column(name="stu_gender")
    private String stuGender;
    @Column(name="stu_class")
    private int stuClass;
    @Column(name="stu_address")
    private String stuAddress;

public Stu(){}

    public Stu(int stuCode, String stuName, String stuGender, int stuClass, String stuAddress) {
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.stuGender = stuGender;
        this.stuClass = stuClass;
        this.stuAddress = stuAddress;
    }

    public int getStuCode() {
        return stuCode;
    }

    public void setStuCode(int stuCode) {
        this.stuCode = stuCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "stuCode=" + stuCode +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuClass=" + stuClass +
                ", stuAddress='" + stuAddress + '\'' +
                '}';
    }
}
