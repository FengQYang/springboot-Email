package com.fqy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    //告诉Spring这是一个要不方法
    @Async
    public void hello(){

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("处理数据中....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
