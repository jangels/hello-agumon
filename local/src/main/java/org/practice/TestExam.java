package org.practice;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestExam {

    public Integer code;

    public static void main(String[] args) {
        TestExam.builder().code(1);
    }
}
