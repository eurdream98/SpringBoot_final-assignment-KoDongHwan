package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class StuDTO {
private int stuCode;


    private String stuName;

    private String stuGender;

    private int stuClass;

    private String stuAddress;

    public StuDTO() {

    }

    public StuDTO(int stuCode, String stuName, String stuGender, int stuClass, String stuAddress) {
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
        return "StuDTO{" +
                "stuCode=" + stuCode +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuClass=" + stuClass +
                ", stuAddress='" + stuAddress + '\'' +
                '}';
    }
}
