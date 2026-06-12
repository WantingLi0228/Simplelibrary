package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//学生数据访问层，使用 JdbcTemplate 实现 CRUD 操作
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //插入学生
    public int insert(Student student) {
        String sql = "INSERT INTO student (name, student_no, class_name) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getStudentNo(), student.getClassName());
    }

    //根据ID查询学生
    public Student findById(Long id) {
        String sql = "SELECT id, name, student_no AS studentNo, class_name AS className, created_at AS createdAt FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
    }

    //根据学号查询学生
    public Student findByStudentNo(String studentNo) {
        String sql = "SELECT id, name, student_no AS studentNo, class_name AS className, created_at AS createdAt FROM student WHERE student_no = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), studentNo);
    }

    //查询所有学生
    public List<Student> findAll() {
        String sql = "SELECT id, name, student_no AS studentNo, class_name AS className, created_at AS createdAt FROM student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    //更新学生信息
    public int update(Student student) {
        String sql = "UPDATE student SET name = ?, student_no = ?, class_name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getStudentNo(), student.getClassName(), student.getId());
    }

    //删除学生
    public int deleteById(Long id) {
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    //检查学号是否存在
    public boolean existsByStudentNo(String studentNo) {
        String sql = "SELECT COUNT(*) FROM student WHERE student_no = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class) > 0;
    }
}