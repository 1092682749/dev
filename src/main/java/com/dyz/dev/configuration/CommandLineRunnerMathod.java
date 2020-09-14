package com.dyz.dev.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import java.net.ServerSocket;
import java.net.Socket;

@Async
@Component

public class CommandLineRunnerMathod implements org.springframework.boot.CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket);
        }
    }
}
