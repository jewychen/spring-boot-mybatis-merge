package org.monkey.domain;

/**
 * Created by monkey on 2017/1/5.
 */
import java.io.Serializable;

public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User:[id:%d, username:%s, password:%s]", id, username, password);
    }
}