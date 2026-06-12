package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学生控制器 - MVC
 *
 * TODO: 实现以下REST API
 *
 * 【MVC】处理HTTP请求，返回JSON
 *
 * GET    /students          - 查询所有学生
 * GET    /students/{id}     - 根据ID查询学生
 * GET    /students/no/{studentNo} - 根据学号查询
 * POST   /students          - 注册学生
 * PUT    /students/{id}     - 更新学生信息
 * DELETE /students/{id}     - 删除学生
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // TODO: 自行实现各个接口
}