package org.monkey.domain;

/**
 * Created by monkey on 2017/1/6.
 */
public class Person {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Person:[id:%d, name:%s]", id ,name);
    }
}
