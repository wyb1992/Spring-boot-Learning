package com.example.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by wyb on 2018/9/6.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ServiceException extends Exception {

    public ServiceException(String msg, Exception e) {
        super(msg + "\n" + e.getMessage());
    }

    public ServiceException(String msg) {
        super(msg);
    }
}
