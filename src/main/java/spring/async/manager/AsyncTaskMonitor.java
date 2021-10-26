package spring.async.manager;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import spring.async.entity.TaskInfo;
import spring.async.entity.TaskStatusEnum;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 22:03
 */
@Component
@Aspect
public class AsyncTaskMonitor {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskMonitor.class);

    @Autowired
    private AsyncTaskManager asyncTaskManager;

    @Around("execution(* spring.async.service.AsyncTaskExecutor.*(..))")
    public void taskHandle(ProceedingJoinPoint joinPoint){
        //获取taskId
        String taskId = joinPoint.getArgs()[1].toString();
        //获取任务信息
        TaskInfo taskInfo = asyncTaskManager.getTaskInfo(taskId);

        logger.info("AsyncTaskMonitor is monitoring async task:{}", taskId);
        taskInfo.setTaskStatusEnum(TaskStatusEnum.RUNNING);

        TaskStatusEnum status = null;
        try {
            joinPoint.proceed();
            status = TaskStatusEnum.DONE;
        } catch (Throwable throwable) {
            status = TaskStatusEnum.FAILED;
            logger.error("AsyncTaskMonitor:async task {} is failed.Error info:{}", taskId, throwable.getMessage());
        }
        taskInfo.setTaskStatusEnum(status);

    }

}
