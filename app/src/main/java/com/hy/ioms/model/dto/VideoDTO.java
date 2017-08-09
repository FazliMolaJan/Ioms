package com.hy.ioms.model.dto;

/**
 * ${description}
 * Created by wsw on 2017/6/1.
 */
@SuppressWarnings("unused")
public class VideoDTO {

    /**
     * result : {"ResultValue":{"Stat":"Init","Channel":1,"ServerAddr":"www.ioms.com.cn","Nic":"Emd.Device.Nic.E1","Camera":"Emd.Device.Camera.E0","Id":2,"ServerPort":554,"Url":"rtsp://www.ioms.com.cn:554/EmdRealTimeVideo-HY_OLMS_000000701-Emd.Service.VideoSender.E0-2.sdp"},"Result":"Ok"}
     * param : {"localWebIndex":"ec14c9f3-9e31-4253-99a1-eb5d2d40e9cd","deviceCode":"HY_OLMS_000000701"}
     * header : {"DeviceCode":"HY_OLMS_000000701"}
     * destInfo : {"DestObject":"Emd.Service.VideoSender.E0","Method":"SendVideoStream","Interface":"Emd.Method.Normal"}
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
         * ResultValue : {"Stat":"Init","Channel":1,"ServerAddr":"www.ioms.com.cn","Nic":"Emd.Device.Nic.E1","Camera":"Emd.Device.Camera.E0","Id":2,"ServerPort":554,"Url":"rtsp://www.ioms.com.cn:554/EmdRealTimeVideo-HY_OLMS_000000701-Emd.Service.VideoSender.E0-2.sdp"}
         * Result : Ok
         */

        private ResultValueBean ResultValue;
        private String Result;

        public ResultValueBean getResultValue() {
            return ResultValue;
        }

        public void setResultValue(ResultValueBean ResultValue) {
            this.ResultValue = ResultValue;
        }

        public String getResult() {
            return Result;
        }

        public void setResult(String Result) {
            this.Result = Result;
        }

        public static class ResultValueBean {
            /**
             * Stat : Init
             * Channel : 1
             * ServerAddr : www.ioms.com.cn
             * Nic : Emd.Device.Nic.E1
             * Camera : Emd.Device.Camera.E0
             * Id : 2
             * ServerPort : 554
             * Url : rtsp://www.ioms.com.cn:554/EmdRealTimeVideo-HY_OLMS_000000701-Emd.Service.VideoSender.E0-2.sdp
             */

            private String Stat;
            private int Channel;
            private String ServerAddr;
            private String Nic;
            private String Camera;
            private int Id;
            private int ServerPort;
            private String Url;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public int getChannel() {
                return Channel;
            }

            public void setChannel(int Channel) {
                this.Channel = Channel;
            }

            public String getServerAddr() {
                return ServerAddr;
            }

            public void setServerAddr(String ServerAddr) {
                this.ServerAddr = ServerAddr;
            }

            public String getNic() {
                return Nic;
            }

            public void setNic(String Nic) {
                this.Nic = Nic;
            }

            public String getCamera() {
                return Camera;
            }

            public void setCamera(String Camera) {
                this.Camera = Camera;
            }

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getServerPort() {
                return ServerPort;
            }

            public void setServerPort(int ServerPort) {
                this.ServerPort = ServerPort;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }
        }
    }

    public static class ParamBean {
        /**
         * localWebIndex : ec14c9f3-9e31-4253-99a1-eb5d2d40e9cd
         * deviceCode : HY_OLMS_000000701
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
    }

    public static class HeaderBean {
        /**
         * DeviceCode : HY_OLMS_000000701
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
        /**
         * DestObject : Emd.Service.VideoSender.E0
         * Method : SendVideoStream
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
}
