package com.wj.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wj.commonutils.R;
import com.wj.eduservice.entity.EduTeacher;
import com.wj.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }
}

