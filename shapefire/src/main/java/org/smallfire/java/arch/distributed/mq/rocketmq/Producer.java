package org.smallfire.java.arch.distributed.mq.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {

        //需要一个producer group名字作为构造方法的参数，这里为producer1
        DefaultMQProducer producer = new DefaultMQProducer("producer1");

        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr(Consumer.ADDR);
        producer.setVipChannelEnabled(false);


        //为避免程序启动的时候报错，添加此代码，可以让rocketMq自动创建topickey
        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        producer.start();

        for(int i=0;i<10;i++){
            try {
                Message message = new Message("TopicTest", "Tag1",
                        ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));

                SendResult sendResult = producer.send(message);

                System.out.println("发送的消息ID:" + sendResult.getMsgId() +"--- 发送消息的状态：" + sendResult.getSendStatus());
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        producer.shutdown();

    }

}
