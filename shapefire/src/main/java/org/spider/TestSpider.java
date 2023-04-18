package org.spider;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TestSpider {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.shapefire.cn");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
