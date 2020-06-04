import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TestRetry {

    public static void main(String[] args) {
        Retryer retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException() // 抛出异常会进行重试
                .retryIfResult(Predicates.equalTo(false)) // 如果接口返回的结果不符合预期,也需要重试
                .withWaitStrategy(WaitStrategies.incrementingWait(10, TimeUnit.SECONDS,10, TimeUnit.SECONDS)) // 重试策略, 此处设置的是重试间隔时间
                .withStopStrategy(StopStrategies.stopAfterAttempt(5)) // 重试次数
                .withRetryListener(new MyRetryListener<>())
                .build();


        try {
            retryer.call(() -> {
                return print();
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    public static boolean print() {
        Integer no = new Random().nextInt(100);

        System.out.println("随机数字:" + no);
        if (no != 0 && no % 5 == 0) {
            System.out.println("重试成功");
            return true;
        }
        System.out.println("重试失败");
        return false;
    }
}
