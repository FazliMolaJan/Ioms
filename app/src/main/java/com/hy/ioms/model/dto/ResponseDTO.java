package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.ResponseVO;

/**
 * 设备端返回结果DTO
 * Created by wsw on 2017/5/10.
 */
@SuppressWarnings("unused")
public class ResponseDTO implements Mapper<ResponseVO> {

    /**
     * result : {"NoticeMsg":"Command is running","Result":"Pending"}
     * param : {"localWebIndex":"1fd7448e-a53c-4f84-a2c1-3d0171e16e33","deviceCode":"HY_OLMS_L_0000101","sessionId":"e88cb5e8913f4171b9660a41aea4a62d","commandId":"94359c8c6e4f45b1b9ab9db3e4d5e150"}
     * header : {"DeviceCode":"HY_OLMS_L_0000101"}
     * destInfo : {"DestObject":"Emd.Service.PicCapture.E0","Method":"PicCapture","Interface":"Emd.Method.Normal"}
     */

    private ResultBean result;
    private ParamBean param;
    private HeaderBean header;
    private DestInfoBean destInfo;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public ParamBean getParam() {
        return param;
    }

    public void setParam(ParamBean param) {
        this.param = param;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public DestInfoBean getDestInfo() {
        return destInfo;
    }

    public void setDestInfo(DestInfoBean destInfo) {
        this.destInfo = destInfo;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "NoticeMsg='" + NoticeMsg + '\'' +
                    ", Result='" + Result + '\'' +
                    ", ErrorMsg='" + ErrorMsg + '\'' +
                    ", result=" + result +
                    '}';
        }

        /**
         * result : {"ErrorMsg":"设备HY_OLMS_L_0000101已经断开","Result":"Failed"}
         * NoticeMsg : Command is running
         * Result : Pending
         */

        private String NoticeMsg;
        private String Result;
        private String ErrorMsg;

        private ResultBean result;

        public String getNoticeMsg() {
            return NoticeMsg;
        }

        public void setNoticeMsg(String NoticeMsg) {
            this.NoticeMsg = NoticeMsg;
        }

        public String getErrorMsg() {
            return ErrorMsg;
        }

        public void setErrorMsg(String ErrorMsg) {
            this.ErrorMsg = ErrorMsg;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }
    }

    public static class ParamBean {
        @Override
        public String toString() {
            return "ParamBean{" +
                    "localWebIndex='" + localWebIndex + '\'' +
                    ", deviceCode='" + deviceCode + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", commandId='" + commandId + '\'' +
                    '}';
        }

        /**
         * localWebIndex : 1fd7448e-a53c-4f84-a2c1-3d0171e16e33
         * deviceCode : HY_OLMS_L_0000101
         * sessionId : e88cb5e8913f4171b9660a41aea4a62d
         * commandId : 94359c8c6e4f45b1b9ab9db3e4d5e150
         */

        private String localWebIndex;
        private String deviceCode;
        private String sessionId;
        private String commandId;

        public String getLocalWebIndex() {
            return localWebIndex;
        }

        public void setLocalWebIndex(String localWebIndex) {
            this.localWebIndex = localWebIndex;
        }

        public String getDeviceCode() {
            return deviceCode;
        }

        public void setDeviceCode(String deviceCode) {
            this.deviceCode = deviceCode;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getCommandId() {
            return commandId;
        }

        public void setCommandId(String commandId) {
            this.commandId = commandId;
        }
    }

    public static class HeaderBean {
        @Override
        public String toString() {
            return "HeaderBean{" +
                    "DeviceCode='" + DeviceCode + '\'' +
                    '}';
        }

        /**
         * DeviceCode : HY_OLMS_L_0000101
         */

        private String DeviceCode;

        public String getDeviceCode() {
            return DeviceCode;
        }

        public void setDeviceCode(String DeviceCode) {
            this.DeviceCode = DeviceCode;
        }
    }

    public static class DestInfoBean {
        @Override
        public String toString() {
            return "DestInfoBean{" +
                    "DestObject='" + DestObject + '\'' +
                    ", Method='" + Method + '\'' +
                    ", Interface='" + Interface + '\'' +
                    '}';
        }

        /**
         * DestObject : Emd.Service.PicCapture.E0
         * Method : PicCapture
         * Interface : Emd.Method.Normal
         */

        private String DestObject;
        private String Method;
        private String Interface;

        public String getDestObject() {
            return DestObject;
        }

        public void setDestObject(String DestObject) {
            this.DestObject = DestObject;
        }

        public String getMethod() {
            return Method;
        }

        public void setMethod(String Method) {
            this.Method = Method;
        }

        public String getInterface() {
            return Interface;
        }

        public void setInterface(String Interface) {
            this.Interface = Interface;
        }
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "result=" + result +
                ", param=" + param +
                ", header=" + header +
                ", destInfo=" + destInfo +
                '}';
    }


    @Override
    public ResponseVO transform() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCommand(this.destInfo.Method);
        responseVO.setResult(this.result.getResult());
        if (this.result.getResult().equalsIgnoreCase("failed")) {
            responseVO.setMessage(this.result.getErrorMsg());
        }
        return responseVO;
    }
}
