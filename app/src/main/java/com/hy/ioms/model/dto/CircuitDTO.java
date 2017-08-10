package com.hy.ioms.model.dto;

/**
 * 线路DTO
 * Created by wsw on 2017/4/14.
 */
@SuppressWarnings("unused")
public class CircuitDTO {

    private Long id;
    private String code;
    private String name;
    private CompanyDTO company;

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

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }
}
