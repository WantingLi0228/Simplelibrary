package com.example.demo.service;

import com.example.demo.model.BorrowRecord;
import java.util.List;


/**
 * 借阅服务层接口 - 核心业务
 */
public interface BorrowService {

    /**
     * 借书
     * - 校验学生存在
     * - 校验图书存在且可借数量 > 0
     * - 创建借阅记录(status=BORROWED)
     * - 图书可借数量 - 1
     * - 【事务】以上操作需要事务支持
     */
    BorrowRecord borrowBook(Long studentId, Long bookId);

    /**
     * 还书
     * - 校验借阅记录存在且未归还
     * - 更新归还日期
     * - 更新状态为RETURNED
     * - 图书可借数量 + 1
     * - 【事务】
     */
    BorrowRecord returnBook(Long borrowRecordId);

    /**
     * 根据ID查询借阅记录
     */
    BorrowRecord getById(Long id);

    /**
     * 查询某学生的借阅历史
     */
    List<BorrowRecord> getByStudentId(Long studentId);

    /**
     * 查询某图书的借阅历史
     */
    List<BorrowRecord> getByBookId(Long bookId);

    /**
     * 查询未归还列表
     */
    List<BorrowRecord> getUnreturned();

    /**
     * 逾期检查
     * - 查询所有未归还记录
     * - 对比应还日期和当前日期
     * - 更新状态为OVERDUE
     */
    void checkOverdue();
}
