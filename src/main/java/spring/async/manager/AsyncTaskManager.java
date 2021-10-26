package spring.async.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.async.entity.TaskInfo;
import spring.async.service.AsyncTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 18:53
 **/

@Component
public class AsyncTaskManager {

    private Map<String, TaskInfo> taskInfoMap = new HashMap<>(10);

    @Autowired
    AsyncTaskExecutor asyncTaskExecutor;

    public TaskInfo initTask(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskId(generateTaskId());


    }

    public String generateTaskId(){
        return UUID.randomUUID().toString();
    }



}
