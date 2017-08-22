package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.PictureVO;

import java.util.List;

/**
 * 计划任务图片DTO
 * Created by wsw on 2017/4/18.
 */
@SuppressWarnings("unused")
public class ScheduleTaskPictureDTO implements Mapper<PictureVO> {
    /**
     * result : {"TaskInfo":{"Type":"PicCapture","PresetId":3,"Enable":true,"Period":"0123456","Height":600,"Time":"2034","Camera":"Emd.Device.Camera.E0","Id":"c91c6f6b75a7478e9f4257dae06b06c9","Width":800,"Name":"???E0_20:34"},"DataType":"FileList","Files":[{"Format":"Jpeg","Length":18362,"DateTime":"2017-04-17 20:35:42","URL":"http://www4.ioms.com.cn:9090/static/\\HY_OLMS_L_0000003\\TaskSchedule\\2017-4\\20170417-203542.jpeg","Name":"/Emd/data/PicCapture/Emd.Device.Camera.E0-20170417-203529-1.jpg"}]}
     * senderInfo : {"Signal":"TaskSchedule","SenderObject":"Emd.Service.TimerTask.E0","Interface":"Emd.Msg.Data"}
     * param : {"_Dummy":"Dummy"}
     * header : {"DeviceCode":"HY_OLMS_L_0000003","TimeStamp":1492432547817}
     */

    private ResultBean result;
    private SenderInfoBean senderInfo;
    private ParamBean param;
    private HeaderBean header;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public SenderInfoBean getSenderInfo() {
        return senderInfo;
    }

    public void setSenderInfo(SenderInfoBean senderInfo) {
        this.senderInfo = senderInfo;
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

    @Override
    public PictureVO transform() {
        PictureVO pictureVO = new PictureVO();
        for (ResultBean.FilesBean filesBean : this.getResult().getFiles()) {
            pictureVO.setDate(filesBean.getDateTime());
            pictureVO.setUrl(filesBean.getURL());
            pictureVO.setDeviceCode(header.getDeviceCode());
        }
        return pictureVO;
    }

    public static class ResultBean {
        /**
         * TaskInfo : {"Type":"PicCapture","PresetId":3,"Enable":true,"Period":"0123456","Height":600,"Time":"2034","Camera":"Emd.Device.Camera.E0","Id":"c91c6f6b75a7478e9f4257dae06b06c9","Width":800,"Name":"???E0_20:34"}
         * DataType : FileList
         * Files : [{"Format":"Jpeg","Length":18362,"DateTime":"2017-04-17 20:35:42","URL":"http://www4.ioms.com.cn:9090/static/\\HY_OLMS_L_0000003\\TaskSchedule\\2017-4\\20170417-203542.jpeg","Name":"/Emd/data/PicCapture/Emd.Device.Camera.E0-20170417-203529-1.jpg"}]
         */

        private TaskInfoBean TaskInfo;
        private String DataType;
        private List<FilesBean> Files;

        public TaskInfoBean getTaskInfo() {
            return TaskInfo;
        }

        public void setTaskInfo(TaskInfoBean TaskInfo) {
            this.TaskInfo = TaskInfo;
        }

        public String getDataType() {
            return DataType;
        }

        public void setDataType(String DataType) {
            this.DataType = DataType;
        }

        public List<FilesBean> getFiles() {
            return Files;
        }

        public void setFiles(List<FilesBean> Files) {
            this.Files = Files;
        }

        public static class TaskInfoBean {
            /**
             * Type : PicCapture
             * PresetId : 3
             * Enable : true
             * Period : 0123456
             * Height : 600
             * Time : 2034
             * Camera : Emd.Device.Camera.E0
             * Id : c91c6f6b75a7478e9f4257dae06b06c9
             * Width : 800
             * Name : ???E0_20:34
             */

            private String Type;
            private int PresetId;
            private boolean Enable;
            private String Period;
            private int Height;
            private String Time;
            private String Camera;
            private String Id;
            private int Width;
            private String Name;

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public int getPresetId() {
                return PresetId;
            }

            public void setPresetId(int PresetId) {
                this.PresetId = PresetId;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getPeriod() {
                return Period;
            }

            public void setPeriod(String Period) {
                this.Period = Period;
            }

            public int getHeight() {
                return Height;
            }

            public void setHeight(int Height) {
                this.Height = Height;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }

            public String getCamera() {
                return Camera;
            }

            public void setCamera(String Camera) {
                this.Camera = Camera;
            }

            public String getId() {
                return Id;
            }

            public void setId(String Id) {
                this.Id = Id;
            }

            public int getWidth() {
                return Width;
            }

            public void setWidth(int Width) {
                this.Width = Width;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class FilesBean {
            /**
             * Format : Jpeg
             * Length : 18362
             * DateTime : 2017-04-17 20:35:42
             * URL : http://www4.ioms.com.cn:9090/static/\HY_OLMS_L_0000003\TaskSchedule\2017-4\20170417-203542.jpeg
             * Name : /Emd/data/PicCapture/Emd.Device.Camera.E0-20170417-203529-1.jpg
             */

            private String Format;
            private int Length;
            private String DateTime;
            private String URL;
            private String Name;

            public String getFormat() {
                return Format;
            }

            public void setFormat(String Format) {
                this.Format = Format;
            }

            public int getLength() {
                return Length;
            }

            public void setLength(int Length) {
                this.Length = Length;
            }

            public String getDateTime() {
                return DateTime;
            }

            public void setDateTime(String DateTime) {
                this.DateTime = DateTime;
            }

            public String getURL() {
                return URL;
            }

            public void setURL(String URL) {
                this.URL = URL;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }

    public static class SenderInfoBean {
        /**
         * Signal : TaskSchedule
         * SenderObject : Emd.Service.TimerTask.E0
         * Interface : Emd.Msg.Data
         */

        private String Signal;
        private String SenderObject;
        private String Interface;

        public String getSignal() {
            return Signal;
        }

        public void setSignal(String Signal) {
            this.Signal = Signal;
        }

        public String getSenderObject() {
            return SenderObject;
        }

        public void setSenderObject(String SenderObject) {
            this.SenderObject = SenderObject;
        }

        public String getInterface() {
            return Interface;
        }

        public void setInterface(String Interface) {
            this.Interface = Interface;
        }
    }

    public static class ParamBean {
        /**
         * _Dummy : Dummy
         */

        private String _Dummy;

        public String get_Dummy() {
            return _Dummy;
        }

        public void set_Dummy(String _Dummy) {
            this._Dummy = _Dummy;
        }
    }

    public static class HeaderBean {
        /**
         * DeviceCode : HY_OLMS_L_0000003
         * TimeStamp : 1492432547817
         */

        private String DeviceCode;
        private long TimeStamp;

        public String getDeviceCode() {
            return DeviceCode;
        }

        public void setDeviceCode(String DeviceCode) {
            this.DeviceCode = DeviceCode;
        }

        public long getTimeStamp() {
            return TimeStamp;
        }

        public void setTimeStamp(long TimeStamp) {
            this.TimeStamp = TimeStamp;
        }
    }
}
