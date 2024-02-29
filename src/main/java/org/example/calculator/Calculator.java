package org.example.calculator;

import org.example.calculator.practice.*;

import java.util.List;

public class Calculator {
//    public static int calculate(int operand1, String operator, int operand2) {
//        if("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if ("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }
//        return 0;

        // enum 을 사용해서 ArithmeticOperatord에 작업요청을 함.
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

//    }
        //  리팩토링 진행 -> NewArithmeticOperator 인터페이스를 통해 의존성을 내렸고,
        // 각 클래스에 책임에 맞게 나누어 두면 리팩토링이 수월하다.
        private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
        public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
            return arithmeticOperators.stream()
                    .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                    .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("옳바른 사칙연산이 아닙니다."));
        }
}
