package com.example.jetpack;

import android.content.res.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class JavaSocket {
    public void tempClass() {
        try {
            Socket socket = SSLSocketFactory.getDefault().createSocket("192.16.9.0",777);
            SSLServerSocketFactory factory=(SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(2222);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
