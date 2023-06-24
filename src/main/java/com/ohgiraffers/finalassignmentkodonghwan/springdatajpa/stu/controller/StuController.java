package com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.controller;

import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.common.Pagenation;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.common.PagingButtonInfo;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto.ClassDTO;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.dto.StuDTO;
import com.ohgiraffers.finalassignmentkodonghwan.springdatajpa.stu.service.StuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/stu")
public class StuController {
    private final StuService stuService;

    public StuController(StuService stuService){this.stuService=stuService;}

    @GetMapping("/{stuCode}")
    public String findStuByCode(@PathVariable int stuCode, Model model){
        StuDTO stu = stuService.findStuByCode(stuCode);
        model.addAttribute("stu",stu);

        return"stu/detail";
    }

    @GetMapping("/list")
    public String findStuList(@PageableDefault Pageable pageable, Model model) {
        /* page -> number, size, sort 파라미터가 Pageable 객체에 담긴다. */
        log.info("pageable : {}", pageable);

        Page<StuDTO> stuList = stuService.findStuList(pageable);

        log.info("조회한 내용 목록 : {}", stuList.getContent());
        log.info("총 페이지 수 : {}", stuList.getTotalPages());
        log.info("총 메뉴 수 : {}", stuList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소 수 : {}", stuList.getSize());
        log.info("해당 페이지에 실제 요소 수 : {}", stuList.getNumberOfElements());
        log.info("첫 페이지 여부 : {}", stuList.isFirst());
        log.info("마지막 페이지 여부 : {}", stuList.isLast());
        log.info("정렬 방식 : {}", stuList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}", stuList.getNumber());

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(stuList);
        model.addAttribute("paging", paging);
        model.addAttribute("stuList", stuList);

        return "stu/list";
    }

    @GetMapping("querymethod")
    public void queryMethodPage() {}
//
    @GetMapping("search")
    public String findByStuClass(@RequestParam Integer stuClass, Model model) {

        List<StuDTO> stuList = stuService.findByStuClass(stuClass);

        model.addAttribute("stuList", stuList);
        model.addAttribute("stuClass", stuClass);

        return "stu/searchResult";
    }
//
    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value="class", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ClassDTO> findClassList() {

        return stuService.findAllClass();
    }
//
    @PostMapping("/regist")
    public String registStu(StuDTO stu) {

        stuService.registNewStu(stu);

        return "redirect:/stu/list";

    }
//
    @GetMapping("/modify")
    public void modifyPage() {}

    @PostMapping("/modify")
    public String modifyMenu(StuDTO stu) {

        stuService.modifyStu(stu);

        return "redirect:/stu/" + stu.getStuCode();
    }
//
    @GetMapping("/delete")
    public void deletePage() {}

    @PostMapping("/delete")
    public String deleteStu(@RequestParam Integer stuCode) {

        stuService.deleteMenu(stuCode);

        return "redirect:/stu/list";
    }




}
