package com.ekfet.netty.client;

import com.ekfet.netty.handle.EchoServerHandle;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.epoll.EpollEventLoopGroup;

public class EchoNettyClient {

    public void start() {
        EpollEventLoopGroup eventLoopGroup = new EpollEventLoopGroup();
        ChannelFuture channelFuture;
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).handler(new EchoServerHandle());
            channelFuture = bootstrap.connect();
            channelFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        try {
            new EchoNettyClient().start();

        } catch (Exception e) {

        }
    }
}
