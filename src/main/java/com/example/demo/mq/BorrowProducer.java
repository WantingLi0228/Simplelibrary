package com.example.demo.mq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RocketMQ生产者
 *
 * TODO: 实现消息发送
 *
 * 【RocketMQ生产者】发送消息到消息队列
 *
 * 应用场景:
 * 1. 借书成功通知
 *    - 借书成功后，发送消息到"borrow-topic"
 *    - 消息内容: borrowRecordId, studentId, bookId, borrowDate
 *
 * 2. 还书成功通知
 *    - 还书成功后，发送消息到"return-topic"
 *    - 消息内容: borrowRecordId, returnDate
 *
 * 3. 逾期提醒消息
 *    - 检测到逾期时，发送消息到"overdue-topic"
 *    - 消息内容: studentId, bookId, dueDate
 *
 * 4. 图书库存同步消息
 *    - 借书/还书时，更新库存后发送库存同步消息
 *    - 用于分布式环境下多实例间的库存同步
 *
 * 【Topic概念】
 * - Topic: 消息主题，用于分类消息
 * - Tag: 消息标签，用于二级分类
 *
 * 【消息发送方式】
 * - syncSend(): 同步发送，等待broker响应
 * - asyncSend(): 异步发送，不等待响应
 * - onewaySend(): 只发送，不关心结果
 */
@Component
public class BorrowProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    // TODO: 发送借书消息
    // public void sendBorrowMessage(Long studentId, Long bookId, LocalDateTime borrowDate) {
    //     // 构造消息体
    //     // rocketMQTemplate.syncSend("borrow-topic:borrow", message);
    // }

    // TODO: 发送还书消息
    // public void sendReturnMessage(Long borrowRecordId, LocalDateTime returnDate) {
    //     // 构造消息体
    //     // rocketMQTemplate.syncSend("return-topic:return", message);
    // }

    // TODO: 发送逾期提醒消息
    // public void sendOverdueMessage(Long studentId, Long bookId, LocalDateTime dueDate) {
    //     // 构造消息体
    //     // rocketMQTemplate.syncSend("overdue-topic:warn", message);
    // }
}