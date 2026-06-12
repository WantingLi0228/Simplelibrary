package com.example.demo.mq;

/**
 * MQ消息体定义
 *
 * TODO: 定义各种消息类型
 *
 * 消息内容:
 * 1. BorrowMessage - 借书消息
 * 2. ReturnMessage - 还书消息
 * 3. OverdueMessage - 逾期消息
 */
public class BorrowMessage {

    private Long studentId;
    private Long bookId;
    private java.time.LocalDateTime borrowDate;

    // TODO: getter/setter/constructor
}