package com.parallel;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class Task {

    @Async
    public ListenableFuture<ResponseVO> doSomething() {

        ResponseVO responseVO = new ResponseVO();
        System.out.println("Start :: Do Something");
        sleep(5000);
        System.out.println("End :: Do Something");
        
        responseVO.setName(Thread.currentThread().getName());

        AsyncResult<ResponseVO> asyncResult = new AsyncResult<>(responseVO);

        return asyncResult;
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
