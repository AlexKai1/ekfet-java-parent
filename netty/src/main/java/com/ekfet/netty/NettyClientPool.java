package com.ekfet.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: NettyClientPool
 * @date 2018/12/5 22:59
 */
public class NettyClientPool {

    static void initClientPool(int poolSize) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    }
                });
        for (int i = 0; i < poolSize; i++) {
            ChannelFuture future =   bootstrap.connect("", 8909).sync();
            future.channel().closeFuture().addListener((r) -> {
                group.shutdownGracefully();
            });
        }




    }
}
