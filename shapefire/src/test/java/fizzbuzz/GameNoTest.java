package fizzbuzz;


import org.jiker.project.fizzbuzz.GameNo;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameNoTest {

    /**
     * Todolist
     * 1.测试类, -->失败, 创建类
     * 2.test 打印原数字
     * 3.test 被3整除
     * 4.test 被5整除
     * 5.test 被3和5整除
     * 6.修改需求: 添加包含指定数字
     * 7.最终需求: 打印100数字
     */

    @Test
    public void should_raw_number() {
        checkGameNo(1, "1");
        checkGameNo(2, "2");
    }

    private void checkGameNo(int i, String print) {
        assertThat(new GameNo(i).toString(), is(print));
    }

    @Test
    public void should_show_fizz_if_raw_number_is_divided_by_3() {
        checkGameNo(3, "fizz");
    }

    @Test
    public void should_show_buzz_if_raw_number_is_divided_by_5() {
        checkGameNo(5, "buzz");
    }

    @Test
    public void should_show_fizzbuzz_if_raw_number_is_divided_by_3_and_5() {
        checkGameNo(15, "fizzbuzz");
    }

    @Test
    public void should_show_fizz_or_buzz_if_raw_number_contains_3_or_5() {
        checkGameNo(13, "fizz");
        checkGameNo(12, "fizz");
        checkGameNo(52, "buzz");
        checkGameNo(25, "buzz");
        checkGameNo(35, "fizzbuzz");
    }

    @Test
    public void test_main() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(new GameNo(i).toString());
        }
    }
}
