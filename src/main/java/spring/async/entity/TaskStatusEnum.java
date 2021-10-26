package spring.async.entity;

public enum TaskStatusEnum {

    STARTED (0,"任务启动") ,
    RUNNING (1,"任务运行中") ,
    DONE (2,"任务完成") ;

    private int state;
    private String stateInfo;

    TaskStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    int getState(){
        return state;
    }

    String getStateInfo(){
        return stateInfo;
    }

}
