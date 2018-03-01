/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.luobosi.net.socket;

import java.io.*;
import java.net.Socket;

/**
 * EchoClient
 *
 * @author luobosi@2dfire.com
 * @since 2018-03-01
 */
public class EchoClient {

    private String host = "localhost";
    private int port = 8000;
    private Socket socket;

    public EchoClient() throws IOException {
        socket = new Socket(host, port);
    }

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        return new PrintWriter(outputStream, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private void talk() throws IOException {
        try {
            BufferedReader reader = getReader(socket);
            PrintWriter writer = getWriter(socket);
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;

            while ((msg = localReader.readLine()) != null) {
                writer.println(msg);
                System.out.println(reader.readLine());

                if ("bye".equals(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}