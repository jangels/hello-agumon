package org.spider;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CrawlerEngine {
    private Queue<String> urlQueue = new LinkedList<>();
    private int maxUrls = 100;
    private int crawledUrls = 0;

    public void start() {
        while (!urlQueue.isEmpty() && crawledUrls < maxUrls) {
            String url = urlQueue.poll();
            new CrawlerTask(url).start();
        }
    }

    class CrawlerTask extends Thread {
        private String url;

        public CrawlerTask(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(this.url);
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
                crawledUrls++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CrawlerEngine engine = new CrawlerEngine();
        engine.urlQueue.offer("https://www.baidu.com/");
        engine.urlQueue.offer("https://www.shapefire.cn/");
        engine.start();
    }
}

