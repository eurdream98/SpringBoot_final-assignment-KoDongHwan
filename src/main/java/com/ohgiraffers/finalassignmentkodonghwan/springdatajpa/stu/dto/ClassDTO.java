package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto;

public class ClassDTO {
    private int stuClass;
    private String classTea;
    private String classMent;

    public ClassDTO(){}

    public ClassDTO(int stuClass, String classTea, String classMent) {
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
        return "ClassDTO{" +
                "stuClass=" + stuClass +
                ", classTea='" + classTea + '\'' +
                ", classMent='" + classMent + '\'' +
                '}';
    }
}
