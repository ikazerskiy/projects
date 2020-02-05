package net.ikazerskiy.projects.service.api.dto;

import java.io.Serializable;

public abstract class CommonDto implements Serializable {

    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
