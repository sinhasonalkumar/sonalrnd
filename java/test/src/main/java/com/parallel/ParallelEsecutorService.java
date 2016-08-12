package com.parallel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.parallel.Task;

@Service
public class ParallelEsecutorService {

    @Autowired
    private Task task;
    
    
    public void start(){
        
        Map<String , ResponseVO> results = new HashMap<>();
        
       AtomicInteger count = new AtomicInteger(0);
       
      int batchSize = 10;
      
        for(int i=1; i<=batchSize;i++){
            ListenableFuture<ResponseVO> doSomething = task.doSomething();
            
            doSomething.addCallback(new ListenableFutureCallback<ResponseVO>() {

                @Override
                public void onSuccess(ResponseVO arg0) {
                   System.out.println("Done");
                   results.put(UUID.randomUUID().toString(), arg0);
                   count.incrementAndGet();
                }

                @Override
                public void onFailure(Throwable arg0) {
                    System.err.println(arg0);
                    
                }
                
            });
        }
        
        while(count.get() != batchSize){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        Set<String> keySet = results.keySet();
        
        for (String key : keySet) {
            System.out.println(results.get(key).getName());
        }
        
        
      
    }
}
