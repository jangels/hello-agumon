package org.smallfire.java.arch.distributed.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */
public class ChatServerHandler extends SimpleChannelInboundHandler {

    private static final ChannelGroup channelGroup = new DefaultChannelGroup("ChannelGroups", GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        String clientAddress = channel.remoteAddress().toString();

        String content = "客户端[" + clientAddress + "]上线了";

        // send to others
        if (channelGroup.size() > 0) {
            channelGroup.writeAndFlush(content);
        }

        // add to channelGroup
        channelGroup.add(channel);

        // local print
        System.out.println(content + ",当前在线人数:" + channelGroup.size());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String clientAddress = channel.remoteAddress().toString();

        String content = "---客户端[" + clientAddress + "]下线了";

        // send to others
        if (channelGroup.size() > 0) {
            channelGroup.writeAndFlush(content);
        }

        // add to channelGroup
        channelGroup.add(channel);

        // local print
        System.out.println(content + ",当前在线人数:" + channelGroup.size());
    }

    /**
     * 读取客户端发送的数据
     *
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @param msg 就是客户端发送的数据
     * @throws Exception
     */

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        Channel channel = ctx.channel();
        String clientAddress = channel.remoteAddress().toString();

        if (channelGroup.size() > 0) {
            channelGroup.forEach(item -> {
                String content;
                if (item == channel) {
                    content = "自己: " + msg;
                } else {
                    content = "\t\t\t\t\t\t" + msg + "| 客户端[" + clientAddress + "] ";
                }
                item.writeAndFlush(content);
            });
        }
    }
}