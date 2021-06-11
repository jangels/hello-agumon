package org.practice;

    public class Consumer extends Thread{

    private PublicQueue publicQueue;

    public Consumer(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (; ; ) {
            publicQueue.get();
        }
    }
}
