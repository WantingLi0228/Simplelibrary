package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生服务实现类
 *
 * TODO: 实现StudentService接口中的业务方法
 *
 * 【依赖注入】使用@Autowired注入StudentDao
 * 【事务】在需要事务的方法上添加@Transactional
 *    - 例: 注册学生时需要保证学生信息完整插入
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    // 实现接口中定义的各种方法
    // TODO: 自行实现每个方法
}