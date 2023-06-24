package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.repository;

import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Classes, Integer> {

    @Query(value="SELECT stu_class, class_tea,class_ment FROM tbl_class ORDER BY stu_class DESC", nativeQuery = true)
    public List<Classes> findAllClass();
}

