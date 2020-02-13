package net.ikazerskiy.projects.service.api.exception;

public class ProjectAlreadyExistsException extends Exception {
    private String name;

    public ProjectAlreadyExistsException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
