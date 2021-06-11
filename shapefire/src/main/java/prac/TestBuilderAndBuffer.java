package prac;


public class TestBuilderAndBuffer {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            new A(builder, buffer).start();
        }
    }
}

class A extends Thread {

    private StringBuilder builder;

    private StringBuffer buffer;

    A(StringBuilder builder, StringBuffer buffer) {
        this.buffer = buffer;
        this.builder = builder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            builder.append("c");
            buffer.append("c");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "]builder:" + builder.length());
        System.out.println("[" + Thread.currentThread().getName() + "]buffer:" + buffer.length());
    }
}