package com.example.demo.dao;

import com.example.demo.model.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//借阅记录数据访问层

@Repository
public class BorrowRecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //插入借阅记录
    public int insert(BorrowRecord record) {
        String sql = "INSERT INTO borrow_record (student_id, book_id, borrow_date, due_date, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                record.getStudentId(),
                record.getBookId(),
                record.getBorrowDate(),
                record.getDueDate(),
                record.getStatus()
        );
    }

    //根据ID查询
    public BorrowRecord findById(Long id) {
        String sql = "SELECT id, student_id AS studentId, book_id AS bookId, borrow_date AS borrowDate, " +
                "due_date AS dueDate, return_date AS returnDate, status, created_at AS createdAt " +
                "FROM borrow_record WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), id);
    }

    //根据学生ID查询
    public List<BorrowRecord> findByStudentId(Long studentId) {
        String sql = "SELECT id, student_id AS studentId, book_id AS bookId, borrow_date AS borrowDate, " +
                "due_date AS dueDate, return_date AS returnDate, status, created_at AS createdAt " +
                "FROM borrow_record WHERE student_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), studentId);
    }

    //根据图书ID查询
    public List<BorrowRecord> findByBookId(Long bookId) {
        String sql = "SELECT id, student_id AS studentId, book_id AS bookId, borrow_date AS borrowDate, " +
                "due_date AS dueDate, return_date AS returnDate, status, created_at AS createdAt " +
                "FROM borrow_record WHERE book_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), bookId);
    }

    //根据状态查询
    public List<BorrowRecord> findByStatus(String status) {
        String sql = "SELECT id, student_id AS studentId, book_id AS bookId, borrow_date AS borrowDate, " +
                "due_date AS dueDate, return_date AS returnDate, status, created_at AS createdAt " +
                "FROM borrow_record WHERE status = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), status);
    }

    //查询所有记录
    public List<BorrowRecord> findAll() {
        String sql = "SELECT id, student_id AS studentId, book_id AS bookId, borrow_date AS borrowDate, " +
                "due_date AS dueDate, return_date AS returnDate, status, created_at AS createdAt " +
                "FROM borrow_record";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class));
    }

    //更新借阅记录（还书时更新status和returnDate）
    public int update(BorrowRecord record) {
        String sql = "UPDATE borrow_record SET return_date = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                record.getReturnDate(),
                record.getStatus(),
                record.getId()
        );
    }

    //统计学生当前借书数量
    public int countByStudentId(Long studentId) {
        String sql = "SELECT COUNT(*) FROM borrow_record WHERE student_id = ? AND status = 'BORROWED'";
        return jdbcTemplate.queryForObject(sql, Integer.class, studentId);
    }
}