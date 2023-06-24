package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.repository;

import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity.Stu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StuRepository extends JpaRepository<Stu, Integer> {

//    List<Stu> findByStuClassGreaterThan(Integer stuClass);
//
//    List<Stu> findByStuCodeGreaterThanOrderByStuCode(Integer stuCode);
//
//    List<Stu> findByStuClassGreaterThan(Integer stuClass, Sort sort);
List<Stu> findByStuClassGreaterThan(Integer stuClass);

    List<Stu> findByStuCodeGreaterThanOrderByStuCode(Integer stuCode);

    List<Stu> findByStuClassGreaterThan(Integer stuClass, Sort sort);
}