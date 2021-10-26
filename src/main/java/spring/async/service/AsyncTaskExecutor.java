package spring.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import spring.async.entity.TaskInfo;


/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 18:46
 **/

@Component
public class AsyncTaskExecutor {

    private static Logger logger = LoggerFactory.getLogger(AsyncTaskExecutor.class);

    @Async
    public void executor(AsyncTaskConstructor asyncTaskConstructor, String taskId){
        logger.info("AsyncTaskExecutor is executing task : {}",taskId);
        asyncTaskConstructor.async();
    }
}
