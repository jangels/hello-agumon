package org.jiker.project.fizzbuzz;

import static java.lang.String.valueOf;

/**
 * 游戏数字类
 */
public class GameNo {
    private int number;

    public GameNo(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        if (isRelatedTo(3) && isRelatedTo(5)) {
            return "fizzbuzz";
        }
        if (isRelatedTo(3)) {
            return "fizz";
        }
        if (isRelatedTo(5)) {
            return "buzz";
        }

        return valueOf(number);
    }

    private boolean isRelatedTo(int i) {
        return number % i == 0 || valueOf(number).contains(valueOf(i));
    }
}
