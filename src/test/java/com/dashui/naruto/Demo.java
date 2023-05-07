package com.dashui.naruto;

import com.dashui.naruto.exception.base.BaseException;

import com.dashui.naruto.exception.domain.Context;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        try (Context context = Context.getCurrentContext()) {
            String result = calculate(10, 0);
            System.out.println(result);
        } catch (BaseException e) {
            logger.error("errorCode: {}, errorMessage: {}, context: {}", e.getErrorCode(), e.getErrorMessage(), e.getContext().getCallStack(), e);
        }
    }

    public static String calculate(int a, int b)  {
        try (Context context = Context.getCurrentContext()) {
            context.addCallStack("calculate");
            int sum = add(a, b);
            int product = multiply(a, b);
            int quotient = divide(a, b);
            return String.format("sum=%d, product=%d, quotient=%d", sum, product, quotient);
        } finally {
            Context.getCurrentContext().removeCallStack("calculate");
        }
    }

    public static int add(int a, int b)  {
        try (Context context = Context.getCurrentContext()) {
            context.addCallStack("add");
            return a + b;
        } finally {
            Context.getCurrentContext().removeCallStack("add");
        }
    }

    public static int multiply(int a, int b) {
        try (Context context = Context.getCurrentContext()) {
            context.addCallStack("multiply");
            return a * b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            Context.getCurrentContext().removeCallStack("multiply");
        }
    }

    public static int divide(int a, int b) throws BaseException {
        try (Context context = Context.getCurrentContext()) {
            context.addCallStack("divide");
            if (b == 0) {
                throw new BaseException("DIVIDE_BY_ZERO", "除数不能为0");
            }
            return a / b;
        } finally {
            Context.getCurrentContext().removeCallStack("divide");
        }
    }
}