package com.hy.ioms.model.dto;

/**
 * 公司DTO
 * Created by wsw on 2017/4/14.
 */
@SuppressWarnings("unused")

public class CompanyDTO {
    private Long id;
    private String code;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
