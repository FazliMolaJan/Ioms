package com.hy.ioms.model.dto;

/**
 * 计划任务结果DTO
 * Created by wsw on 2017/4/18.
 */
@SuppressWarnings("unused")
public class ScheduleTaskResultDTO {
    private String content;
    private Long deviceId;
    private Long id;
    private String modifiedDate;
    private String taskUuid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }
}
