package com.example.demo.controller;

import com.example.demo.model.BorrowRecord;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 借阅控制器 - MVC
 *
 * TODO: 实现以下REST API
 *
 * 【MVC】处理HTTP请求，返回JSON
 *
 * POST   /borrow/borrow      - 借书 (studentId, bookId参数)
 * POST   /borrow/return      - 还书 (borrowRecordId参数)
 * GET    /borrow/{id}       - 根据ID查询借阅记录
 * GET    /borrow/student/{studentId} - 查询某学生的借阅历史
 * GET    /borrow/book/{bookId}      - 查询某图书的借阅历史
 * GET    /borrow/unreturned - 查询未归还列表
 * POST   /borrow/check-overdue - 触发逾期检查(通常为定时任务)
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    // TODO: 自行实现各个接口
}