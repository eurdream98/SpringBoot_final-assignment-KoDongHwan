package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.service;

import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto.ClassDTO;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto.StuDTO;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity.Classes;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.entity.Stu;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.repository.ClassRepository;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.repository.StuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StuService {

    private final ClassRepository classRepository;
    private final StuRepository stuRepository;
    private final ModelMapper modelMapper;

    public StuService(StuRepository stuRepository, ClassRepository classRepository, ModelMapper modelMapper) {
        this.stuRepository = stuRepository;
        this.classRepository = classRepository;
        this.modelMapper = modelMapper;
    }

    /* 1. 메뉴 코드로 메뉴 하나 조회 : findById */
    public StuDTO findStuByCode(int StuCode) {

        Stu stu = stuRepository.findById(StuCode).orElseThrow(IllegalArgumentException::new);

        return modelMapper.map(stu, StuDTO.class);
    }

//    /* 2-1. 메뉴 테이블의 모든 행 조회 : findAll(Sort) */
//    public List<StuDTO> findStuList() {
//
//        List<Stu> menuList = stuRepository.findAll(Sort.by("stuCode").descending());
//
//        return menuList.stream().map(menu -> modelMapper.map(menu, StuDTO.class)).collect(Collectors.toList());
//    }

    /* 2-2. 메뉴 테이블의 요청 된 페이지에 맞는 요소 조회 : findAll(Pageable) */
    public Page<StuDTO> findStuList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()  - 1,
                pageable.getPageSize(),
                Sort.by("stuCode").descending());

        Page<Stu> stuList = stuRepository.findAll(pageable);

        return stuList.map(stu -> modelMapper.map(stu, StuDTO.class));
    }

    /* 3. 입력 받은 가격을 초과하는 메뉴 목록 조회 : Query Method Test */
    public List<StuDTO> findByStuClass(Integer stuClass) {

        //List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(menuPrice);
        //List<Menu> menuList = menuRepository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);
        List<Stu> stuList = stuRepository.findByStuClassGreaterThan(stuClass);

        return stuList.stream().map(stu -> modelMapper.map(stu, StuDTO.class)).collect(Collectors.toList());
    }
//
    /* 4. 카테고리 목록 조회 : JPQL or Native Query 사용 */
    public List<ClassDTO> findAllClass() {

        List<Classes> categoryList = classRepository.findAllClass();

        return categoryList.stream().map(category -> modelMapper.map(category,ClassDTO.class)).collect(Collectors.toList());
    }
//
    /* 5. 메뉴 등록 : save */
    @Transactional
    public void registNewStu(StuDTO newStu) {

        stuRepository.save(modelMapper.map(newStu, Stu.class));

    }
//
    @Transactional
    public void modifyStu(StuDTO stu) {
        Stu foundStu = stuRepository.findById(stu.getStuCode()).orElseThrow(IllegalArgumentException::new);
        foundStu.setStuName(stu.getStuName());
    }
//
    @Transactional
    public void deleteMenu(Integer stuCode) {

        stuRepository.deleteById(stuCode);
    }
}

