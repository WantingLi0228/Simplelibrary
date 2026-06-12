package com.example.demo.model;

import java.time.LocalDateTime;

/**
 * 借阅记录实体类
 *
 * 业务字段：
 * - id: 记录ID (主键)
 * - studentId: 学生ID (外键)
 * - bookId: 图书ID (外键)
 * - borrowDate: 借书日期
 * - dueDate: 应还日期
 * - returnDate: 实际归还日期 (可为null表示未归还)
 * - status: 状态 (BORROWED=借出, RETURNED=已归还, OVERDUE=逾期)
 * - createdAt: 创建时间
 */
public class BorrowRecord {

    private Long id;
    private Long studentId;
    private Long bookId;
    private java.time.LocalDateTime borrowDate;
    private java.time.LocalDateTime dueDate;
    private java.time.LocalDateTime returnDate;
    private String status; // BORROWED, RETURNED, OVERDUE
    private java.time.LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}