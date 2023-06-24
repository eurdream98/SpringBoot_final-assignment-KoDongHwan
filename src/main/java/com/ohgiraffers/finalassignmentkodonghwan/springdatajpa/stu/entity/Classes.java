package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_class")
public class Classes {
    @Id
    @Column(name="stu_class")
    private int stuClass;

    @Column(name="class_tea")
    private String classTea;
    @Column(name="class_ment")
    private String classMent;
    public Classes(){}

    public Classes(int stuClass, String classTea, String classMent) {
        this.stuClass = stuClass;
        this.classTea = classTea;
        this.classMent = classMent;
    }

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public String getClassTea() {
        return classTea;
    }

    public void setClassTea(String classTea) {
        this.classTea = classTea;
    }

    public String getClassMent() {
        return classMent;
    }

    public void setClassMent(String classMent) {
        this.classMent = classMent;
    }

    @Override
    public String toString() {
        return "Class{" +
                "stuClass=" + stuClass +
                ", classTea='" + classTea + '\'' +
                ", classMent='" + classMent + '\'' +
                '}';
    }
}
