package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;


/**
 * 学生服务层接口
 */
public interface StudentService {

    /**
     * 注册学生
     * - 校验学号唯一性
     */
    Student register(Student student);

    /**
     * 根据ID查询学生
     */
    Student getById(Long id);

    /**
     * 根据学号查询学生
     */
    Student getByStudentNo(String studentNo);

    /**
     * 查询所有学生
     */
    List<Student> getAll();

    /**
     * 更新学生信息
     */
    Student update(Student student);

    /**
     * 删除学生
     */
    void delete(Long id);
}
