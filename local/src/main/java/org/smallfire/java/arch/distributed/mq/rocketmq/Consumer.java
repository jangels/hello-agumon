package org.smallfire.java.arch.distributed.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Consumer {

    public static final String ADDR = "127.0.0.1:9876";

    public static void main(String[] args) throws MQClientException {
        //设置消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_LRW_DEV_SUBS");

        consumer.setVipChannelEnabled(false);
        consumer.setNamesrvAddr(ADDR);
        //设置消费者端消息拉取策略，表示从哪里开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //设置消费者拉取消息的策略，*表示消费该topic下的所有消息，也可以指定tag进行消息过滤
        consumer.subscribe("TopicTest", "*");

        //消费者端启动消息监听，一旦生产者发送消息被监听到，就打印消息，和rabbitmq中的handlerDelivery类似
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : msgs) {
                    String topic = messageExt.getTopic();
                    String tag = messageExt.getTags();
                    String msg = new String(messageExt.getBody());
                    System.out.println("*********************************");
                    System.out.println("消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + msg + ", tag:" + tag + ", topic:" + topic);
                    System.out.println("*********************************");
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //调用start()方法启动consumer
        consumer.start();
        System.out.println("Consumer Started....");
    }

}
