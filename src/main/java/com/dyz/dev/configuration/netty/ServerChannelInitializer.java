package com.dyz.dev.configuration.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//import java.nio.channels.SocketChannel;

@Component
public class ServerChannelInitializer extends ChannelInitializer<io.netty.channel.socket.SocketChannel> {
  @Autowired
  NotifyHandler notifyHandler;

  @Override
  protected void initChannel(io.netty.channel.socket.SocketChannel socketChannel) throws Exception {
    //    socketChannel.pipeline().addLast(new SslHandler(engine));
    socketChannel.pipeline().addLast("http-codec", new HttpServerCodec());
    socketChannel.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
    socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
    socketChannel.pipeline().addLast(new StringDecoder());
    socketChannel.pipeline().addLast(new StringEncoder());
    socketChannel.pipeline().addLast(notifyHandler);
  }
}
