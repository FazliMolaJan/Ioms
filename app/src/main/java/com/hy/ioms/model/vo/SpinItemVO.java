package com.hy.ioms.model.vo;

/**
 * ${description}
 * Created by wsw on 2017/5/10.
 */

public class SpinItemVO {
    private String name;
    private int type;
    private int id;

    public SpinItemVO(String name, int type, int id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
