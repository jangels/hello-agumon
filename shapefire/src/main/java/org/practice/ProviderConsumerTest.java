package org.practice;

public class ProviderConsumerTest {
    public static void main(String[] args) {
        PublicQueue publicQueue = new PublicQueue();
        Provider provider = new Provider(publicQueue);
        Consumer consumer = new Consumer(publicQueue);
        provider.start();
        consumer.start();
    }
}
