package org.smallfire.java.arch.distributed.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        //客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            //设置相关参数
            bootstrap.group(group) //设置线程组
                    .channel(NioSocketChannel.class) // 使用 NioSocketChannel 作为客户端的通道实现
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            //加入处理器
                            ChannelPipeline pipeline = channel.pipeline();

                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("decoder", new StringDecoder());

                            pipeline.addLast(new ChatClientHandler());
                        }
                    });


            //启动客户端去连接服务器端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();

            Channel channel = channelFuture.channel();

            System.out.println(channel.localAddress() + " 客户端启动完成.");

            // 获取控制台输入

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String content = scanner.nextLine();
                if (StringUtils.isNotBlank(content)) {
                    // 控制台输入发送到服务器
                    channel.writeAndFlush(content);
                }
            }

        } finally {
            group.shutdownGracefully();
        }
    }
}