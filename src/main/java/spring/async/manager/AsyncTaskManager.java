package spring.async.manager;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.async.entity.TaskInfo;
import spring.async.entity.TaskStatusEnum;
import spring.async.service.AsyncTaskConstructor;
import spring.async.service.AsyncTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 18:53
 **/

@Component
public class AsyncTaskManager {

    private static final LoadingCache<String, TaskInfo> taskInfoLoadingCache = CacheBuilder
            .newBuilder()
            .maximumSize(10)
            .expireAfterWrite(24, TimeUnit.HOURS)
            .build(new CacheLoader<String, TaskInfo>() {
                @Override
                public TaskInfo load(String s) throws Exception {
                    return new TaskInfo();
                }
            });

    //private Map<String, TaskInfo> taskInfoMap = new HashMap<>(10);

    @Autowired
    AsyncTaskExecutor asyncTaskExecutor;

    public TaskInfo initTask(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskId(generateTaskId());
        taskInfo.setTaskStatusEnum(TaskStatusEnum.STARTED);
        setTaskInfo(taskInfo);
        return taskInfo;
    }

    public TaskInfo submit(AsyncTaskConstructor asyncTaskConstructor){
        TaskInfo taskInfo = initTask();
        String taskId = taskInfo.getTaskId();
        asyncTaskExecutor.executor(asyncTaskConstructor,taskId);
        return taskInfo;
    }

    public TaskInfo getTaskInfo(String taskId){
        return taskInfoLoadingCache.getIfPresent(taskId);
    }

    public void setTaskInfo(TaskInfo taskInfo){
        taskInfoLoadingCache.put(taskInfo.getTaskId(),taskInfo);
    }

    public TaskStatusEnum getTaskStatus(String taskId){
        return taskInfoLoadingCache.getIfPresent(taskId).getTaskStatusEnum();
    }

    public String generateTaskId(){
        return UUID.randomUUID().toString();
    }



}
