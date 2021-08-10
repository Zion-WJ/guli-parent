package com.wj.eduservice.controller;


import com.wj.commonutils.R;
import com.wj.eduservice.entity.EduTeacher;
import com.wj.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping
    public R list() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items", list);
    }

    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id) {
        boolean removeById = eduTeacherService.removeById(id);
        if (removeById) {
            return R.ok();
        }
        return R.error();
    }
}

