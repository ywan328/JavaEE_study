package com.kkb.exception;

/**
 * 自定义异常类
 * @author Yan Wang
 * @version 1.0
 */
public class OutNumberBoundException extends Throwable {
    public OutNumberBoundException(String s) {
        super(s);
    }
}
