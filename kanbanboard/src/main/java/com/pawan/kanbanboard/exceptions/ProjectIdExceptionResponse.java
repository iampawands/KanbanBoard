package com.pawan.kanbanboard.exceptions;

public class ProjectIdExceptionResponse {
    private  String projectIdentifier;

    public ProjectIdExceptionResponse(String projectId) {
        this.projectIdentifier = projectId;
    }

    public String getProjectId() {
        return projectIdentifier;
    }

    public void setProjectId(String projectId) {
        this.projectIdentifier = projectId;
    }
}
