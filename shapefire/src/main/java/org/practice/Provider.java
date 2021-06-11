package org.practice;

public class Provider extends Thread{

    private PublicQueue publicQueue;

    public Provider(PublicQueue publicQueue) {
        this.publicQueue = publicQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            publicQueue.put(String.valueOf(i));
        }
    }
}
