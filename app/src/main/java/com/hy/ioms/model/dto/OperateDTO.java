package com.hy.ioms.model.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsw on 2017/8/9.
 */

public class OperateDTO {

    private DestInfo DestInfo;
    private Map<String, Object> Param;

    public OperateDTO(DestInfo destInfo, Map<String, Object> param) {
        this.DestInfo = destInfo;
        Param = param;
    }

    public OperateDTO() {
    }

    public OperateDTO(OperateDTO.DestInfo destInfo) {
        DestInfo = destInfo;
        Param = new HashMap<>();
    }

    public DestInfo getDestInfo() {
        return DestInfo;
    }

    public void setDestInfo(DestInfo destInfo) {
        this.DestInfo = destInfo;
    }

    public Map<String, Object> getParam() {
        return Param;
    }

    public void setParam(Map<String, Object> param) {
        Param = param;
    }


    public static class DestInfo {
        public DestInfo(String destObject, String method, String anInterface) {
            DestObject = destObject;
            Method = method;
            Interface = anInterface;
        }

        String DestObject;
        String Method;
        String Interface;

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
}
