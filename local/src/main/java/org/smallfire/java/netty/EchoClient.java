package org.smallfire.java.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * UdpClientUtils
 *
 * @author zhengkai.blog.csdn.net
 */
@Slf4j
public class EchoClient {
    private static DatagramSocket clientSocket = null;
    private static InetSocketAddress serverAddress = null;
    /**
     * 编码格式，一般gbk或者utf-8
     */
    private static String CHARSET_NAME = "utf-8";
    private static String UDP_URL = "localhost";
    private static Integer UDP_PORT = 9999;

    public static DatagramSocket getDatagramSocket() throws SocketException {

        if(clientSocket != null){
            return clientSocket;
        }else{

            clientSocket = new DatagramSocket(UDP_PORT);

            try {
                clientSocket.connect(
                        InetAddress.getByName(UDP_URL), UDP_PORT);
                clientSocket.setReuseAddress(true);

                LocalUDPDataReciever.getInstance().startup();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            return clientSocket;

        }
    }

    public static InetSocketAddress getInetSocketAddress(String host, int port) throws SocketException {
        return (serverAddress == null) ? new InetSocketAddress(host, port) : serverAddress;
    }

    public static void send(String host, int port, String msg) throws IOException {
        try {
            log.info("UDP发送数据:" + msg);
            byte[] data = msg.getBytes(CHARSET_NAME);
            DatagramPacket packet = new DatagramPacket(data, data.length);
            getDatagramSocket().send(packet);
            log.info("发送完毕");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        //main方法用于测试
        for (int i = 0; i < 5; i++) {
            log.info(">>>>>>第" + (i + 1) + "次发送UDP");
            EchoClient.send(EchoClient.UDP_URL, EchoClient.UDP_PORT, "开始测试");
            Thread.sleep(500);
        }

        getDatagramSocket().close();

    }

}

