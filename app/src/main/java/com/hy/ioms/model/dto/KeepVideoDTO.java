package com.hy.ioms.model.dto;

/**
 * Created by wsw on 2017/6/2.
 */

public class KeepVideoDTO {

    /**
     * result : {"Result":"Ok"}
     * param : {"localWebIndex":"1ace4da2-0cd4-470a-9b97-4e66be596986","deviceCode":"HY_OLMS_000000702"}
     * header : {"DeviceCode":"HY_OLMS_000000702"}
     * destInfo : {"DestObject":"Emd.Service.VideoSender.E0","Method":"KeepVideoStream","Interface":"Emd.Method.Normal"}
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
        /**
         * Result : Ok
         */

        private String Result;

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "Result='" + Result + '\'' +
                    '}';
        }
    }

    public static class ParamBean {
        /**
         * localWebIndex : 1ace4da2-0cd4-470a-9b97-4e66be596986
         * deviceCode : HY_OLMS_000000702
         */

        private String localWebIndex;
        private String deviceCode;

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

        @Override
        public String toString() {
            return "ParamBean{" +
                    "localWebIndex='" + localWebIndex + '\'' +
                    ", deviceCode='" + deviceCode + '\'' +
                    '}';
        }
    }

    public static class HeaderBean {
        /**
         * DeviceCode : HY_OLMS_000000702
         */

        private String DeviceCode;

        public String getDeviceCode() {
            return DeviceCode;
        }

        public void setDeviceCode(String DeviceCode) {
            this.DeviceCode = DeviceCode;
        }

        @Override
        public String toString() {
            return "HeaderBean{" +
                    "DeviceCode='" + DeviceCode + '\'' +
                    '}';
        }
    }

    public static class DestInfoBean {
        /**
         * DestObject : Emd.Service.VideoSender.E0
         * Method : KeepVideoStream
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

        @Override
        public String toString() {
            return "DestInfoBean{" +
                    "DestObject='" + DestObject + '\'' +
                    ", Method='" + Method + '\'' +
                    ", Interface='" + Interface + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "KeepVideoDTO{" +
                "result=" + result +
                ", param=" + param +
                ", header=" + header +
                ", destInfo=" + destInfo +
                '}';
    }
}
