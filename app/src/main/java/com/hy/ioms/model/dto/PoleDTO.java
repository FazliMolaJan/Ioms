package com.hy.ioms.model.dto;

/**
 * 杆塔DTO
 * Created by wsw on 2017/4/14.
 */
@SuppressWarnings("unused")
public class PoleDTO {
    private Long id;
    private String code;
    private String name;
    private CircuitDTO circuit;

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

    public CircuitDTO getCircuit() {
        return circuit;
    }

    public void setCircuit(CircuitDTO circuit) {
        this.circuit = circuit;
    }
}
