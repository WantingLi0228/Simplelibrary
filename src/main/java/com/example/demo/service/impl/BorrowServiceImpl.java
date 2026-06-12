package com.example.demo.service.impl;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BorrowRecordDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.model.BorrowRecord;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 借阅服务实现类 - 核心业务逻辑
 *
 * TODO: 实现BorrowService接口中的业务方法
 *
 * 【依赖注入】注入StudentDao, BookDao, BorrowRecordDao
 *
 * 【事务@Transactional】借书和还书操作需要事务保证一致性:
 * - 借书: 创建借阅记录 + 扣减库存 必须同时成功或失败
 * - 还书: 更新记录状态 + 增加库存 必须同时成功或失败
 *
 * 【AOP】checkOverdue()方法会被@Aspect切面拦截，实现逾期提醒日志
 */
@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BorrowRecordDao borrowRecordDao;

    // 实现接口中定义的各种方法
    // TODO: 自行实现每个方法
}