package spring.async.entity;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-26 18:01
 **/

public class TaskInfo {

    private String taskId;

    private TaskStatusEnum taskStatusEnum;

    public TaskInfo() {
    }

    public TaskInfo(String taskId, TaskStatusEnum taskStatusEnum) {
        this.taskId = taskId;
        this.taskStatusEnum = taskStatusEnum;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskStatusEnum getTaskStatusEnum() {
        return taskStatusEnum;
    }

    public void setTaskStatusEnum(TaskStatusEnum taskStatusEnum) {
        this.taskStatusEnum = taskStatusEnum;
    }
}
