package com.example.demo.mq;

import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * RocketMQ消费者
 *
 * TODO: 实现消息消费
 *
 * 【RocketMQ消费者】订阅消息队列，处理消息
 *
 * 消费者分组(Consumer Group):
 * - 同一分组内的消费者会负载均衡消费消息
 * - 不同分组的消费者会重复消费消息(广播模式)
 *
 * 应用场景:
 * 1. 借书消息处理
 *    - 监听"borrow-topic"
 *    - 收到消息后: 发送短信/邮件通知学生借书成功
 *    - 或: 更新相关统计报表
 *
 * 2. 还书消息处理
 *    - 监听"return-topic"
 *    - 收到消息后: 发送还书成功通知
 *    - 或: 更新图书可用数量缓存
 *
 * 3. 逾期提醒处理
 *    - 监听"overdue-topic"
 *    - 收到消息后: 发送逾期催还通知(短信/邮件)
 *    - 或: 调用外部通知服务
 *
 * 4. 库存同步处理
 *    - 监听库存同步topic
 *    - 收到消息后: 更新本地缓存的库存数量
 *
 * 【消息过滤】
 * - 使用Tag进行消息过滤: consumer.subscribe("topic", "tag1 || tag2")
 * - 使用SQL表达式过滤: consumer.subscribe("topic", "key IS NOT NULL")
 *
 * 【消费模式】
 * - 集群消费: 默认模式，消息在组内负载均衡
 * - 广播消费: 每条消息被组内所有消费者消费
 */
@Component
public class BorrowConsumer {

    // TODO: 实现BorrowMessageListener实现RocketMQListener接口
    // @Component
    // public static class BorrowMessageListener implements RocketMQListener<BorrowMessage> {
    //     @Override
    //     public void onMessage(BorrowMessage message) {
    //         // 处理借书消息
    //         // 发送通知、更新报表等
    //     }
    // }

    // TODO: 实现ReturnMessageListener
    // @Component
    // public static class ReturnMessageListener implements RocketMQListener<ReturnMessage> {
    //     @Override
    //     public void onMessage(ReturnMessage message) {
    //         // 处理还书消息
    //     }
    // }

    // TODO: 实现OverdueMessageListener
    // @Component
    // public static class OverdueMessageListener implements RocketMQListener<OverdueMessage> {
    //     @Override
    //     public void onMessage(OverdueMessage message) {
    //         // 处理逾期提醒消息
    //     }
    // }
}