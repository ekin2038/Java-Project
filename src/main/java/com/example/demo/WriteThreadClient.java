package com.example.demo;

import util.SocketWrapper;

import java.io.IOException;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private SocketWrapper socketWrapper;
    MovieMessage movieMessage;
    public WriteThreadClient(SocketWrapper socketWrapper, MovieMessage movieMessage) {
        this.socketWrapper = socketWrapper;
        this.movieMessage= movieMessage;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            socketWrapper.write(movieMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



