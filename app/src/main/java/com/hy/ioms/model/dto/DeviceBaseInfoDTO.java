package com.hy.ioms.model.dto;

import java.util.List;

/**
 * 设备baseInfo DTO
 * Created by wsw on 2017/5/9.
 */
@SuppressWarnings("unused")

public class DeviceBaseInfoDTO {

    /**
     * Agent : {"Hy":[{"ServerType":"Public","Enable":false}],"GuoWang":[],"NanWang":[]}
     * Device : {"Battery":[{"Charger1":"Solar","Charger2":"None","Voltage":12,"Enable":true,"PhysicalPort":"/dev/ttySP4","ID":1,"Capcity":20,"Name":"Emd.Device.Battery.E0"}],"Nic":[{"PowerSwitchMode":"Gpio","Type":"Ethernet","NetworkType":"Local","Baudwide":"100M","Enable":true,"Interface":"eth2","Name":"Emd.Device.Nic.E0"},{"PowerSwitchMode":"Gpio","Type":"4G","NetworkType":"Internet","Baudwide":"200K","Model":"ZTE_ME3630","Enable":true,"Manufacory":"ZTE","Name":"Emd.Device.Nic.E1"}],"Camera":[{"PowerSwitchGpioIndex":"xx","PowerSwitchMode":"Gpio","Model":"DS-2DF5274-D","Enable":true,"Manufacory":"hikvision","WorkDependInstance":["Emd.Device.Nic.E0"],"Addr":"192.168.8.245","Name":"Emd.Device.Camera.E0"}],"Wifi":[{"PowerSwitchMode":"Gpio","Model":"HLK-RM04","Enable":false,"Manufacory":"HLK-RM04","WorkDependInstance":["Emd.Device.Nic.E0"]}],"Mainboard":[{"I2CPhysicalPort":"/dev/i2c-0","BatteryID":1,"BoardTempModel":"TMP75","Enable":true,"BatteryPhysicalPort":"/dev/ttySP4","Name":"Emd.Device.Mainboard.E0"}],"Sensor":[{"Type":"Temprature","Usage":"BoardTemp","Manufactory":"XX","Model":"TMP75","Enable":false,"PhysicalPort":"/dev/i2c-0","Communication":"I2C"},{"Type":"Pressure","Usage":"Pressure","Manufactory":"XX","Model":"MPL115A2","Enable":false,"PhysicalPort":"/dev/i2c-0","Communication":"I2C"}]}
     * DeviceCode : HY_OLMS_000000101
     * Service : {"Debugger":[{"Enable":true,"Name":"Emd.Service.Debugger.E0"}],"PowerManager":[{"Enable":true,"Name":"Emd.Service.PowerManager.E0"}],"Upgrader":[{"Enable":true,"Name":"Emd.Service.Upgrader.E0"}],"TimerTask":[{"Enable":true,"Name":"Emd.Service.TimerTask.E0"}],"SysMonitor":[{"Enable":true,"Name":"Emd.Service.SysMonitor.E0"}],"Vpn":[{"Enable":true,"Name":"Emd.Service.Vpn.E0"}],"PicCapture":[{"Enable":true,"Name":"Emd.Service.PicCapture.E0"}],"VideoSender":[{"Enable":true,"Name":"Emd.Service.VideoSender.E0"}]}
     */

    private AgentBean Agent;
    private DeviceBean Device;
    private String DeviceCode;
    private ServiceBean Service;

    public AgentBean getAgent() {
        return Agent;
    }

    public void setAgent(AgentBean Agent) {
        this.Agent = Agent;
    }

    public DeviceBean getDevice() {
        return Device;
    }

    public void setDevice(DeviceBean Device) {
        this.Device = Device;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String DeviceCode) {
        this.DeviceCode = DeviceCode;
    }

    public ServiceBean getService() {
        return Service;
    }

    public void setService(ServiceBean Service) {
        this.Service = Service;
    }

    public static class AgentBean {
        private List<HyBean> Hy;
        private List<?> GuoWang;
        private List<?> NanWang;

        public List<HyBean> getHy() {
            return Hy;
        }

        public void setHy(List<HyBean> Hy) {
            this.Hy = Hy;
        }

        public List<?> getGuoWang() {
            return GuoWang;
        }

        public void setGuoWang(List<?> GuoWang) {
            this.GuoWang = GuoWang;
        }

        public List<?> getNanWang() {
            return NanWang;
        }

        public void setNanWang(List<?> NanWang) {
            this.NanWang = NanWang;
        }

        public static class HyBean {
            /**
             * ServerType : Public
             * Enable : false
             */

            private String ServerType;
            private boolean Enable;

            public String getServerType() {
                return ServerType;
            }

            public void setServerType(String ServerType) {
                this.ServerType = ServerType;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }
        }
    }

    public static class DeviceBean {
        private List<BatteryBean> Battery;
        private List<NicBean> Nic;
        private List<CameraBean> Camera;
        private List<WifiBean> Wifi;
        private List<MainboardBean> Mainboard;
        private List<SensorBean> Sensor;

        public List<BatteryBean> getBattery() {
            return Battery;
        }

        public void setBattery(List<BatteryBean> Battery) {
            this.Battery = Battery;
        }

        public List<NicBean> getNic() {
            return Nic;
        }

        public void setNic(List<NicBean> Nic) {
            this.Nic = Nic;
        }

        public List<CameraBean> getCamera() {
            return Camera;
        }

        public void setCamera(List<CameraBean> Camera) {
            this.Camera = Camera;
        }

        public List<WifiBean> getWifi() {
            return Wifi;
        }

        public void setWifi(List<WifiBean> Wifi) {
            this.Wifi = Wifi;
        }

        public List<MainboardBean> getMainboard() {
            return Mainboard;
        }

        public void setMainboard(List<MainboardBean> Mainboard) {
            this.Mainboard = Mainboard;
        }

        public List<SensorBean> getSensor() {
            return Sensor;
        }

        public void setSensor(List<SensorBean> Sensor) {
            this.Sensor = Sensor;
        }

        public static class BatteryBean {
            /**
             * Charger1 : Solar
             * Charger2 : None
             * Voltage : 12
             * Enable : true
             * PhysicalPort : /dev/ttySP4
             * ID : 1
             * Capcity : 20
             * Name : Emd.Device.Battery.E0
             */

            private String Charger1;
            private String Charger2;
            private int Voltage;
            private boolean Enable;
            private String PhysicalPort;
            private int ID;
            private int Capcity;
            private String Name;

            public String getCharger1() {
                return Charger1;
            }

            public void setCharger1(String Charger1) {
                this.Charger1 = Charger1;
            }

            public String getCharger2() {
                return Charger2;
            }

            public void setCharger2(String Charger2) {
                this.Charger2 = Charger2;
            }

            public int getVoltage() {
                return Voltage;
            }

            public void setVoltage(int Voltage) {
                this.Voltage = Voltage;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getPhysicalPort() {
                return PhysicalPort;
            }

            public void setPhysicalPort(String PhysicalPort) {
                this.PhysicalPort = PhysicalPort;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getCapcity() {
                return Capcity;
            }

            public void setCapcity(int Capcity) {
                this.Capcity = Capcity;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class NicBean {
            /**
             * PowerSwitchMode : Gpio
             * Type : Ethernet
             * NetworkType : Local
             * Baudwide : 100M
             * Enable : true
             * Interface : eth2
             * Name : Emd.Device.Nic.E0
             * Model : ZTE_ME3630
             * Manufacory : ZTE
             */

            private String PowerSwitchMode;
            private String Type;
            private String NetworkType;
            private String Baudwide;
            private boolean Enable;
            private String Interface;
            private String Name;
            private String Model;
            private String Manufacory;

            public String getPowerSwitchMode() {
                return PowerSwitchMode;
            }

            public void setPowerSwitchMode(String PowerSwitchMode) {
                this.PowerSwitchMode = PowerSwitchMode;
            }

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public String getNetworkType() {
                return NetworkType;
            }

            public void setNetworkType(String NetworkType) {
                this.NetworkType = NetworkType;
            }

            public String getBaudwide() {
                return Baudwide;
            }

            public void setBaudwide(String Baudwide) {
                this.Baudwide = Baudwide;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getInterface() {
                return Interface;
            }

            public void setInterface(String Interface) {
                this.Interface = Interface;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getModel() {
                return Model;
            }

            public void setModel(String Model) {
                this.Model = Model;
            }

            public String getManufacory() {
                return Manufacory;
            }

            public void setManufacory(String Manufacory) {
                this.Manufacory = Manufacory;
            }
        }

        public static class CameraBean {
            /**
             * PowerSwitchGpioIndex : xx
             * PowerSwitchMode : Gpio
             * Model : DS-2DF5274-D
             * Enable : true
             * Manufacory : hikvision
             * WorkDependInstance : ["Emd.Device.Nic.E0"]
             * Addr : 192.168.8.245
             * Name : Emd.Device.Camera.E0
             */

            private String PowerSwitchGpioIndex;
            private String PowerSwitchMode;
            private String Model;
            private boolean Enable;
            private String Manufacory;
            private String Addr;
            private String Name;
            private List<String> WorkDependInstance;

            public String getPowerSwitchGpioIndex() {
                return PowerSwitchGpioIndex;
            }

            public void setPowerSwitchGpioIndex(String PowerSwitchGpioIndex) {
                this.PowerSwitchGpioIndex = PowerSwitchGpioIndex;
            }

            public String getPowerSwitchMode() {
                return PowerSwitchMode;
            }

            public void setPowerSwitchMode(String PowerSwitchMode) {
                this.PowerSwitchMode = PowerSwitchMode;
            }

            public String getModel() {
                return Model;
            }

            public void setModel(String Model) {
                this.Model = Model;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getManufacory() {
                return Manufacory;
            }

            public void setManufacory(String Manufacory) {
                this.Manufacory = Manufacory;
            }

            public String getAddr() {
                return Addr;
            }

            public void setAddr(String Addr) {
                this.Addr = Addr;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public List<String> getWorkDependInstance() {
                return WorkDependInstance;
            }

            public void setWorkDependInstance(List<String> WorkDependInstance) {
                this.WorkDependInstance = WorkDependInstance;
            }
        }

        public static class WifiBean {
            /**
             * PowerSwitchMode : Gpio
             * Model : HLK-RM04
             * Enable : false
             * Manufacory : HLK-RM04
             * WorkDependInstance : ["Emd.Device.Nic.E0"]
             */

            private String PowerSwitchMode;
            private String Model;
            private boolean Enable;
            private String Manufacory;
            private List<String> WorkDependInstance;

            public String getPowerSwitchMode() {
                return PowerSwitchMode;
            }

            public void setPowerSwitchMode(String PowerSwitchMode) {
                this.PowerSwitchMode = PowerSwitchMode;
            }

            public String getModel() {
                return Model;
            }

            public void setModel(String Model) {
                this.Model = Model;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getManufacory() {
                return Manufacory;
            }

            public void setManufacory(String Manufacory) {
                this.Manufacory = Manufacory;
            }

            public List<String> getWorkDependInstance() {
                return WorkDependInstance;
            }

            public void setWorkDependInstance(List<String> WorkDependInstance) {
                this.WorkDependInstance = WorkDependInstance;
            }
        }

        public static class MainboardBean {
            /**
             * I2CPhysicalPort : /dev/i2c-0
             * BatteryID : 1
             * BoardTempModel : TMP75
             * Enable : true
             * BatteryPhysicalPort : /dev/ttySP4
             * Name : Emd.Device.Mainboard.E0
             */

            private String I2CPhysicalPort;
            private int BatteryID;
            private String BoardTempModel;
            private boolean Enable;
            private String BatteryPhysicalPort;
            private String Name;

            public String getI2CPhysicalPort() {
                return I2CPhysicalPort;
            }

            public void setI2CPhysicalPort(String I2CPhysicalPort) {
                this.I2CPhysicalPort = I2CPhysicalPort;
            }

            public int getBatteryID() {
                return BatteryID;
            }

            public void setBatteryID(int BatteryID) {
                this.BatteryID = BatteryID;
            }

            public String getBoardTempModel() {
                return BoardTempModel;
            }

            public void setBoardTempModel(String BoardTempModel) {
                this.BoardTempModel = BoardTempModel;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getBatteryPhysicalPort() {
                return BatteryPhysicalPort;
            }

            public void setBatteryPhysicalPort(String BatteryPhysicalPort) {
                this.BatteryPhysicalPort = BatteryPhysicalPort;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class SensorBean {
            /**
             * Type : Temprature
             * Usage : BoardTemp
             * Manufactory : XX
             * Model : TMP75
             * Enable : false
             * PhysicalPort : /dev/i2c-0
             * Communication : I2C
             */

            private String Type;
            private String Usage;
            private String Manufactory;
            private String Model;
            private boolean Enable;
            private String PhysicalPort;
            private String Communication;

            public String getType() {
                return Type;
            }

            public void setType(String Type) {
                this.Type = Type;
            }

            public String getUsage() {
                return Usage;
            }

            public void setUsage(String Usage) {
                this.Usage = Usage;
            }

            public String getManufactory() {
                return Manufactory;
            }

            public void setManufactory(String Manufactory) {
                this.Manufactory = Manufactory;
            }

            public String getModel() {
                return Model;
            }

            public void setModel(String Model) {
                this.Model = Model;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getPhysicalPort() {
                return PhysicalPort;
            }

            public void setPhysicalPort(String PhysicalPort) {
                this.PhysicalPort = PhysicalPort;
            }

            public String getCommunication() {
                return Communication;
            }

            public void setCommunication(String Communication) {
                this.Communication = Communication;
            }
        }
    }

    public static class ServiceBean {
        private List<DebuggerBean> Debugger;
        private List<PowerManagerBean> PowerManager;
        private List<UpgraderBean> Upgrader;
        private List<TimerTaskBean> TimerTask;
        private List<SysMonitorBean> SysMonitor;
        private List<VpnBean> Vpn;
        private List<PicCaptureBean> PicCapture;
        private List<VideoSenderBean> VideoSender;

        public List<DebuggerBean> getDebugger() {
            return Debugger;
        }

        public void setDebugger(List<DebuggerBean> Debugger) {
            this.Debugger = Debugger;
        }

        public List<PowerManagerBean> getPowerManager() {
            return PowerManager;
        }

        public void setPowerManager(List<PowerManagerBean> PowerManager) {
            this.PowerManager = PowerManager;
        }

        public List<UpgraderBean> getUpgrader() {
            return Upgrader;
        }

        public void setUpgrader(List<UpgraderBean> Upgrader) {
            this.Upgrader = Upgrader;
        }

        public List<TimerTaskBean> getTimerTask() {
            return TimerTask;
        }

        public void setTimerTask(List<TimerTaskBean> TimerTask) {
            this.TimerTask = TimerTask;
        }

        public List<SysMonitorBean> getSysMonitor() {
            return SysMonitor;
        }

        public void setSysMonitor(List<SysMonitorBean> SysMonitor) {
            this.SysMonitor = SysMonitor;
        }

        public List<VpnBean> getVpn() {
            return Vpn;
        }

        public void setVpn(List<VpnBean> Vpn) {
            this.Vpn = Vpn;
        }

        public List<PicCaptureBean> getPicCapture() {
            return PicCapture;
        }

        public void setPicCapture(List<PicCaptureBean> PicCapture) {
            this.PicCapture = PicCapture;
        }

        public List<VideoSenderBean> getVideoSender() {
            return VideoSender;
        }

        public void setVideoSender(List<VideoSenderBean> VideoSender) {
            this.VideoSender = VideoSender;
        }

        public static class DebuggerBean {
            /**
             * Enable : true
             * Name : Emd.Service.Debugger.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class PowerManagerBean {
            /**
             * Enable : true
             * Name : Emd.Service.PowerManager.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class UpgraderBean {
            /**
             * Enable : true
             * Name : Emd.Service.Upgrader.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class TimerTaskBean {
            /**
             * Enable : true
             * Name : Emd.Service.TimerTask.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class SysMonitorBean {
            /**
             * Enable : true
             * Name : Emd.Service.SysMonitor.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class VpnBean {
            /**
             * Enable : true
             * Name : Emd.Service.Vpn.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class PicCaptureBean {
            /**
             * Enable : true
             * Name : Emd.Service.PicCapture.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class VideoSenderBean {
            /**
             * Enable : true
             * Name : Emd.Service.VideoSender.E0
             */

            private boolean Enable;
            private String Name;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }
}
