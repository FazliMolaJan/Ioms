package com.hy.ioms.model.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作DTO,用于转换为json发送到后台
 * Created by wsw on 2017/8/9.
 */
@SuppressWarnings("unused")
public class OperateDTO {

    public OperateDTO() {
    }

    public OperateDTO(OperateDTO.DestInfo destInfo) {
        DestInfo = destInfo;
        Param = new HashMap<>();
    }

    public OperateDTO(OperateDTO.DestInfo destInfo, Map<String, Object> param) {
        DestInfo = destInfo;
        Param = param;
    }

    public DestInfo DestInfo;
    public Map<String, Object> Param;

    public static class DestInfo {
        String DestObject;
        String Method;
        String Interface;

        public DestInfo() {
        }

        public DestInfo(String destObject, String method, String anInterface) {
            DestObject = destObject;
            Method = method;
            Interface = anInterface;
        }

        public String getDestObject() {
            return DestObject;
        }

        public void setDestObject(String destObject) {
            DestObject = destObject;
        }

        public String getMethod() {
            return Method;
        }

        public void setMethod(String method) {
            Method = method;
        }

        public String getInterface() {
            return Interface;
        }

        public void setInterface(String anInterface) {
            Interface = anInterface;
        }


    }

    public OperateDTO.DestInfo getDestInfo() {
        return DestInfo;
    }

    public void setDestInfo(OperateDTO.DestInfo destInfo) {
        DestInfo = destInfo;
    }

    public Map<String, Object> getParam() {
        return Param;
    }

    public void setParam(Map<String, Object> param) {
        Param = param;
    }
}
