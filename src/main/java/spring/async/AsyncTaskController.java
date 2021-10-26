package spring.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.async.entity.TaskInfo;
import spring.async.manager.AsyncTaskManager;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 22:27
 */

@RestController
@RequestMapping(value = "/api/asynctask")
public class AsyncTaskController {

    @Autowired
    AsyncTaskManager asyncTaskManager;

    @RequestMapping(value = "/startTask", method = RequestMethod.GET)
    public String startAsyncTask() {
        //调用任务管理器中的submit去提交一个异步任务
        TaskInfo taskInfo = asyncTaskManager.submit(() -> {
            System.out.println("__________");
            try {
                //模拟异步，睡眠6秒
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("__________");
        });
        return taskInfo.getTaskId();
    }

    @RequestMapping(value = "/getTaskStatus", method = RequestMethod.GET)
    public String getTaskStatus(
            @RequestParam("taskId") String taskId) {
        return asyncTaskManager.getTaskStatus(taskId).getStateInfo();
    }

}
