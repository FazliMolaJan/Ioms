package com.hy.ioms.model.dto;

import com.hy.ioms.model.Mapper;
import com.hy.ioms.model.vo.DeviceStatusVO;

import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
@SuppressWarnings("unused")
public class DeviceStatusDTO implements Mapper<DeviceStatusVO> {

    /**
     * Agent : {"Hy":[{"HeartBeatInterval":44,"Stat":"Error","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Agent.Hy.E0"},{"HeartBeatInterval":44,"Stat":"Error","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Agent.Hy.E1"}],"Sendu":[{"Stat":"Error","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Agent.Sendu.E0"}],"NanWang":[{"Enable":false}]}
     * Device : {"Battery":[{"WorkTemprature":0,"EndTime":"2017-08-11 15:10:20","Senders":null,"ChargePower":281.7920837402344,"Users":null,"ChargeCurrent1":0.7144759893417358,"ChargeSwitch1":1,"ChargeCurrent2":0,"Name":"Emd.Device.Battery.E0","DurationTime":598,"ChargeSwitch2":1,"InstanceName":"Emd.Device.Battery.E0","Stat":"PowerDown","Voltage":13.49129581451416,"Enable":true,"ChargeVotage2":19.96608543395996,"ChargeVotage1":19.948362350463867,"Level":0.9982590675354004,"ID":1,"UsedPower":450.80828857421875,"OutPutCurrent":0.7603920102119446}],"Nic":[{"InstanceName":"Emd.Device.Nic.E0","Bcast":"192.168.20.255","Stat":"Ready","Senders":null,"Mask":"255.255.255.0","Enable":true,"Users":null,"Addr":"192.168.20.109","Interface":"eth0","Name":"Emd.Device.Nic.E0"},{"Enable":false}],"Camera":[{"InstanceName":"Emd.Device.Camera.E0","Stat":"Ready","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Device.Camera.E0"}],"Gps":[{"Enable":false}],"Wifi":[{"Enable":false}],"Mainboard":[{"InstanceName":"Emd.Device.Mainboard.E0","Temperature":46.75,"Stat":"PowerDown","Senders":null,"UpTime":1465,"Enable":true,"BoardVoltage":12.73469352722168,"Users":null,"BoardCurrent":0.7603920102119446,"Name":"Emd.Device.Mainboard.E0"}],"Sensor":[{"Enable":false},{"Enable":false}]}
     * accessServerTimeStamp : 1502435733278
     * Service : {"Debugger":[{"Stat":"Idle","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.Debugger.E0"}],"PowerManager":[{"Stat":"Idle","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.PowerManager.E0"}],"Upgrader":[{"InstanceName":"Emd.Service.Upgrader.E0","HardwareModel":"I283_DATA_V10A","Stat":"Idle","NewEmdPkgStat":{"Version":"1.1.33","ErrorMsg":"","PkgStat":"Ready","ReleaseDate":""},"Senders":null,"HardwarePlatform":"imx28","Enable":true,"Users":null,"CurrentVerInfo":{"RootFs":{"ReleaseDesc":"内核引脚定义做了调整，根据主板硬件型号采用不同的引脚文件","Version":"1.0.6","ReleaseDate":"2017-06-21"},"Deps":{"ReleaseDesc":"加入pptp vpn客户端支持程序","Version":"1.0.8","ReleaseDate":"2017-06-21"},"Emd":{"ReleaseDesc":"1. 增加系统上电后开启ETH0 2分钟; 2.修复 SYSMONITOR 休眠阻塞; 3.修改抓图命令bug，采用-frames参数","Version":"1.1.36","ReleaseDate":"2017-07-21"},"Kernel":{"Version":"Linux version 2.6.35.3-670-g914558e+ (root@Linux-mint-32) (gcc version 4.4.4 (4.4.4_09.06.2010) ) #74 PREEMPT Wed Jun 21 16:16:57 CST 2017\n"}},"Name":"Emd.Service.Upgrader.E0"}],"TimerTask":[{"Stat":"Idle","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.TimerTask.E0"}],"SysMonitor":[{"Stat":"Working","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.SysMonitor.E0"}],"Vpn":[{"Stat":"Idle","Senders":null,"Connected":false,"Enable":true,"Users":null,"VpnIP":"","Name":"Emd.Service.Vpn.E0"}],"MsgProcessor":[{"Stat":"Idle","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.MsgProcessor.E0"}],"PicCapture":[{"Stat":"Idle","Senders":null,"Enable":true,"Users":null,"Name":"Emd.Service.PicCapture.E0"}],"VideoSender":[{"Stat":"Idle","Senders":null,"Enable":true,"VideoSenderTaskList":[],"Users":null,"Name":"Emd.Service.VideoSender.E0"}]}
     */

    private AgentBean Agent;
    private DeviceBean Device;
    private String accessServerTimeStamp;
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

    public String getAccessServerTimeStamp() {
        return accessServerTimeStamp;
    }

    public void setAccessServerTimeStamp(String accessServerTimeStamp) {
        this.accessServerTimeStamp = accessServerTimeStamp;
    }

    public ServiceBean getService() {
        return Service;
    }

    public void setService(ServiceBean Service) {
        this.Service = Service;
    }


    public static class AgentBean {
        private List<HyBean> Hy;
        private List<SenduBean> Sendu;
        private List<NanWangBean> NanWang;

        public List<HyBean> getHy() {
            return Hy;
        }

        public void setHy(List<HyBean> Hy) {
            this.Hy = Hy;
        }

        public List<SenduBean> getSendu() {
            return Sendu;
        }

        public void setSendu(List<SenduBean> Sendu) {
            this.Sendu = Sendu;
        }

        public List<NanWangBean> getNanWang() {
            return NanWang;
        }

        public void setNanWang(List<NanWangBean> NanWang) {
            this.NanWang = NanWang;
        }

        public static class HyBean {
            /**
             * HeartBeatInterval : 44
             * Stat : Error
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Agent.Hy.E0
             */

            private int HeartBeatInterval;
            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public int getHeartBeatInterval() {
                return HeartBeatInterval;
            }

            public void setHeartBeatInterval(int HeartBeatInterval) {
                this.HeartBeatInterval = HeartBeatInterval;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class SenduBean {
            /**
             * Stat : Error
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Agent.Sendu.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class NanWangBean {
            /**
             * Enable : false
             */

            private boolean Enable;

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
        private List<GpsBean> Gps;
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

        public List<GpsBean> getGps() {
            return Gps;
        }

        public void setGps(List<GpsBean> Gps) {
            this.Gps = Gps;
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
             * WorkTemprature : 0
             * EndTime : 2017-08-11 15:10:20
             * Senders : null
             * ChargePower : 281.7920837402344
             * Users : null
             * ChargeCurrent1 : 0.7144759893417358
             * ChargeSwitch1 : 1
             * ChargeCurrent2 : 0
             * Name : Emd.Device.Battery.E0
             * DurationTime : 598
             * ChargeSwitch2 : 1
             * InstanceName : Emd.Device.Battery.E0
             * Stat : PowerDown
             * Voltage : 13.49129581451416
             * Enable : true
             * ChargeVotage2 : 19.96608543395996
             * ChargeVotage1 : 19.948362350463867
             * Level : 0.9982590675354004
             * ID : 1
             * UsedPower : 450.80828857421875
             * OutPutCurrent : 0.7603920102119446
             */

            private int WorkTemprature;
            private String EndTime;
            private Object Senders;
            private double ChargePower;
            private Object Users;
            private double ChargeCurrent1;
            private int ChargeSwitch1;
            private int ChargeCurrent2;
            private String Name;
            private int DurationTime;
            private int ChargeSwitch2;
            private String InstanceName;
            private String Stat;
            private double Voltage;
            private boolean Enable;
            private double ChargeVotage2;
            private double ChargeVotage1;
            private double Level;
            private int ID;
            private double UsedPower;
            private double OutPutCurrent;

            public int getWorkTemprature() {
                return WorkTemprature;
            }

            public void setWorkTemprature(int WorkTemprature) {
                this.WorkTemprature = WorkTemprature;
            }

            public String getEndTime() {
                return EndTime;
            }

            public void setEndTime(String EndTime) {
                this.EndTime = EndTime;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public double getChargePower() {
                return ChargePower;
            }

            public void setChargePower(double ChargePower) {
                this.ChargePower = ChargePower;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public double getChargeCurrent1() {
                return ChargeCurrent1;
            }

            public void setChargeCurrent1(double ChargeCurrent1) {
                this.ChargeCurrent1 = ChargeCurrent1;
            }

            public int getChargeSwitch1() {
                return ChargeSwitch1;
            }

            public void setChargeSwitch1(int ChargeSwitch1) {
                this.ChargeSwitch1 = ChargeSwitch1;
            }

            public int getChargeCurrent2() {
                return ChargeCurrent2;
            }

            public void setChargeCurrent2(int ChargeCurrent2) {
                this.ChargeCurrent2 = ChargeCurrent2;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getDurationTime() {
                return DurationTime;
            }

            public void setDurationTime(int DurationTime) {
                this.DurationTime = DurationTime;
            }

            public int getChargeSwitch2() {
                return ChargeSwitch2;
            }

            public void setChargeSwitch2(int ChargeSwitch2) {
                this.ChargeSwitch2 = ChargeSwitch2;
            }

            public String getInstanceName() {
                return InstanceName;
            }

            public void setInstanceName(String InstanceName) {
                this.InstanceName = InstanceName;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public double getVoltage() {
                return Voltage;
            }

            public void setVoltage(double Voltage) {
                this.Voltage = Voltage;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public double getChargeVotage2() {
                return ChargeVotage2;
            }

            public void setChargeVotage2(double ChargeVotage2) {
                this.ChargeVotage2 = ChargeVotage2;
            }

            public double getChargeVotage1() {
                return ChargeVotage1;
            }

            public void setChargeVotage1(double ChargeVotage1) {
                this.ChargeVotage1 = ChargeVotage1;
            }

            public double getLevel() {
                return Level;
            }

            public void setLevel(double Level) {
                this.Level = Level;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public double getUsedPower() {
                return UsedPower;
            }

            public void setUsedPower(double UsedPower) {
                this.UsedPower = UsedPower;
            }

            public double getOutPutCurrent() {
                return OutPutCurrent;
            }

            public void setOutPutCurrent(double OutPutCurrent) {
                this.OutPutCurrent = OutPutCurrent;
            }
        }

        public static class NicBean {
            /**
             * InstanceName : Emd.Device.Nic.E0
             * Bcast : 192.168.20.255
             * Stat : Ready
             * Senders : null
             * Mask : 255.255.255.0
             * Enable : true
             * Users : null
             * Addr : 192.168.20.109
             * Interface : eth0
             * Name : Emd.Device.Nic.E0
             */

            private String InstanceName;
            private String Bcast;
            private String Stat;
            private Object Senders;
            private String Mask;
            private boolean Enable;
            private Object Users;
            private String Addr;
            private String Interface;
            private String Name;

            public String getInstanceName() {
                return InstanceName;
            }

            public void setInstanceName(String InstanceName) {
                this.InstanceName = InstanceName;
            }

            public String getBcast() {
                return Bcast;
            }

            public void setBcast(String Bcast) {
                this.Bcast = Bcast;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public String getMask() {
                return Mask;
            }

            public void setMask(String Mask) {
                this.Mask = Mask;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getAddr() {
                return Addr;
            }

            public void setAddr(String Addr) {
                this.Addr = Addr;
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
        }

        public static class CameraBean {
            /**
             * InstanceName : Emd.Device.Camera.E0
             * Stat : Ready
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Device.Camera.E0
             */

            private String InstanceName;
            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getInstanceName() {
                return InstanceName;
            }

            public void setInstanceName(String InstanceName) {
                this.InstanceName = InstanceName;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class GpsBean {
            /**
             * Enable : false
             */

            private boolean Enable;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }
        }

        public static class WifiBean {
            /**
             * Enable : false
             */

            private boolean Enable;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }
        }

        public static class MainboardBean {
            /**
             * InstanceName : Emd.Device.Mainboard.E0
             * Temperature : 46.75
             * Stat : PowerDown
             * Senders : null
             * UpTime : 1465
             * Enable : true
             * BoardVoltage : 12.73469352722168
             * Users : null
             * BoardCurrent : 0.7603920102119446
             * Name : Emd.Device.Mainboard.E0
             */

            private String InstanceName;
            private double Temperature;
            private String Stat;
            private Object Senders;
            private int UpTime;
            private boolean Enable;
            private double BoardVoltage;
            private Object Users;
            private double BoardCurrent;
            private String Name;

            public String getInstanceName() {
                return InstanceName;
            }

            public void setInstanceName(String InstanceName) {
                this.InstanceName = InstanceName;
            }

            public double getTemperature() {
                return Temperature;
            }

            public void setTemperature(double Temperature) {
                this.Temperature = Temperature;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public int getUpTime() {
                return UpTime;
            }

            public void setUpTime(int UpTime) {
                this.UpTime = UpTime;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public double getBoardVoltage() {
                return BoardVoltage;
            }

            public void setBoardVoltage(double BoardVoltage) {
                this.BoardVoltage = BoardVoltage;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public double getBoardCurrent() {
                return BoardCurrent;
            }

            public void setBoardCurrent(double BoardCurrent) {
                this.BoardCurrent = BoardCurrent;
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
             * Enable : false
             */

            private boolean Enable;

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
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
        private List<MsgProcessorBean> MsgProcessor;
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

        public List<MsgProcessorBean> getMsgProcessor() {
            return MsgProcessor;
        }

        public void setMsgProcessor(List<MsgProcessorBean> MsgProcessor) {
            this.MsgProcessor = MsgProcessor;
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
             * Stat : Idle
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.Debugger.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * Stat : Idle
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.PowerManager.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * InstanceName : Emd.Service.Upgrader.E0
             * HardwareModel : I283_DATA_V10A
             * Stat : Idle
             * NewEmdPkgStat : {"Version":"1.1.33","ErrorMsg":"","PkgStat":"Ready","ReleaseDate":""}
             * Senders : null
             * HardwarePlatform : imx28
             * Enable : true
             * Users : null
             * CurrentVerInfo : {"RootFs":{"ReleaseDesc":"内核引脚定义做了调整，根据主板硬件型号采用不同的引脚文件","Version":"1.0.6","ReleaseDate":"2017-06-21"},"Deps":{"ReleaseDesc":"加入pptp vpn客户端支持程序","Version":"1.0.8","ReleaseDate":"2017-06-21"},"Emd":{"ReleaseDesc":"1. 增加系统上电后开启ETH0 2分钟; 2.修复 SYSMONITOR 休眠阻塞; 3.修改抓图命令bug，采用-frames参数","Version":"1.1.36","ReleaseDate":"2017-07-21"},"Kernel":{"Version":"Linux version 2.6.35.3-670-g914558e+ (root@Linux-mint-32) (gcc version 4.4.4 (4.4.4_09.06.2010) ) #74 PREEMPT Wed Jun 21 16:16:57 CST 2017\n"}}
             * Name : Emd.Service.Upgrader.E0
             */

            private String InstanceName;
            private String HardwareModel;
            private String Stat;
            private NewEmdPkgStatBean NewEmdPkgStat;
            private Object Senders;
            private String HardwarePlatform;
            private boolean Enable;
            private Object Users;
            private CurrentVerInfoBean CurrentVerInfo;
            private String Name;

            public String getInstanceName() {
                return InstanceName;
            }

            public void setInstanceName(String InstanceName) {
                this.InstanceName = InstanceName;
            }

            public String getHardwareModel() {
                return HardwareModel;
            }

            public void setHardwareModel(String HardwareModel) {
                this.HardwareModel = HardwareModel;
            }

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public NewEmdPkgStatBean getNewEmdPkgStat() {
                return NewEmdPkgStat;
            }

            public void setNewEmdPkgStat(NewEmdPkgStatBean NewEmdPkgStat) {
                this.NewEmdPkgStat = NewEmdPkgStat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public String getHardwarePlatform() {
                return HardwarePlatform;
            }

            public void setHardwarePlatform(String HardwarePlatform) {
                this.HardwarePlatform = HardwarePlatform;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public CurrentVerInfoBean getCurrentVerInfo() {
                return CurrentVerInfo;
            }

            public void setCurrentVerInfo(CurrentVerInfoBean CurrentVerInfo) {
                this.CurrentVerInfo = CurrentVerInfo;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public static class NewEmdPkgStatBean {
                /**
                 * Version : 1.1.33
                 * ErrorMsg :
                 * PkgStat : Ready
                 * ReleaseDate :
                 */

                private String Version;
                private String ErrorMsg;
                private String PkgStat;
                private String ReleaseDate;

                public String getVersion() {
                    return Version;
                }

                public void setVersion(String Version) {
                    this.Version = Version;
                }

                public String getErrorMsg() {
                    return ErrorMsg;
                }

                public void setErrorMsg(String ErrorMsg) {
                    this.ErrorMsg = ErrorMsg;
                }

                public String getPkgStat() {
                    return PkgStat;
                }

                public void setPkgStat(String PkgStat) {
                    this.PkgStat = PkgStat;
                }

                public String getReleaseDate() {
                    return ReleaseDate;
                }

                public void setReleaseDate(String ReleaseDate) {
                    this.ReleaseDate = ReleaseDate;
                }
            }

            public static class CurrentVerInfoBean {
                /**
                 * RootFs : {"ReleaseDesc":"内核引脚定义做了调整，根据主板硬件型号采用不同的引脚文件","Version":"1.0.6","ReleaseDate":"2017-06-21"}
                 * Deps : {"ReleaseDesc":"加入pptp vpn客户端支持程序","Version":"1.0.8","ReleaseDate":"2017-06-21"}
                 * Emd : {"ReleaseDesc":"1. 增加系统上电后开启ETH0 2分钟; 2.修复 SYSMONITOR 休眠阻塞; 3.修改抓图命令bug，采用-frames参数","Version":"1.1.36","ReleaseDate":"2017-07-21"}
                 * Kernel : {"Version":"Linux version 2.6.35.3-670-g914558e+ (root@Linux-mint-32) (gcc version 4.4.4 (4.4.4_09.06.2010) ) #74 PREEMPT Wed Jun 21 16:16:57 CST 2017\n"}
                 */

                private RootFsBean RootFs;
                private DepsBean Deps;
                private EmdBean Emd;
                private KernelBean Kernel;

                public RootFsBean getRootFs() {
                    return RootFs;
                }

                public void setRootFs(RootFsBean RootFs) {
                    this.RootFs = RootFs;
                }

                public DepsBean getDeps() {
                    return Deps;
                }

                public void setDeps(DepsBean Deps) {
                    this.Deps = Deps;
                }

                public EmdBean getEmd() {
                    return Emd;
                }

                public void setEmd(EmdBean Emd) {
                    this.Emd = Emd;
                }

                public KernelBean getKernel() {
                    return Kernel;
                }

                public void setKernel(KernelBean Kernel) {
                    this.Kernel = Kernel;
                }

                public static class RootFsBean {
                    /**
                     * ReleaseDesc : 内核引脚定义做了调整，根据主板硬件型号采用不同的引脚文件
                     * Version : 1.0.6
                     * ReleaseDate : 2017-06-21
                     */

                    private String ReleaseDesc;
                    private String Version;
                    private String ReleaseDate;

                    public String getReleaseDesc() {
                        return ReleaseDesc;
                    }

                    public void setReleaseDesc(String ReleaseDesc) {
                        this.ReleaseDesc = ReleaseDesc;
                    }

                    public String getVersion() {
                        return Version;
                    }

                    public void setVersion(String Version) {
                        this.Version = Version;
                    }

                    public String getReleaseDate() {
                        return ReleaseDate;
                    }

                    public void setReleaseDate(String ReleaseDate) {
                        this.ReleaseDate = ReleaseDate;
                    }
                }

                public static class DepsBean {
                    /**
                     * ReleaseDesc : 加入pptp vpn客户端支持程序
                     * Version : 1.0.8
                     * ReleaseDate : 2017-06-21
                     */

                    private String ReleaseDesc;
                    private String Version;
                    private String ReleaseDate;

                    public String getReleaseDesc() {
                        return ReleaseDesc;
                    }

                    public void setReleaseDesc(String ReleaseDesc) {
                        this.ReleaseDesc = ReleaseDesc;
                    }

                    public String getVersion() {
                        return Version;
                    }

                    public void setVersion(String Version) {
                        this.Version = Version;
                    }

                    public String getReleaseDate() {
                        return ReleaseDate;
                    }

                    public void setReleaseDate(String ReleaseDate) {
                        this.ReleaseDate = ReleaseDate;
                    }
                }

                public static class EmdBean {
                    /**
                     * ReleaseDesc : 1. 增加系统上电后开启ETH0 2分钟; 2.修复 SYSMONITOR 休眠阻塞; 3.修改抓图命令bug，采用-frames参数
                     * Version : 1.1.36
                     * ReleaseDate : 2017-07-21
                     */

                    private String ReleaseDesc;
                    private String Version;
                    private String ReleaseDate;

                    public String getReleaseDesc() {
                        return ReleaseDesc;
                    }

                    public void setReleaseDesc(String ReleaseDesc) {
                        this.ReleaseDesc = ReleaseDesc;
                    }

                    public String getVersion() {
                        return Version;
                    }

                    public void setVersion(String Version) {
                        this.Version = Version;
                    }

                    public String getReleaseDate() {
                        return ReleaseDate;
                    }

                    public void setReleaseDate(String ReleaseDate) {
                        this.ReleaseDate = ReleaseDate;
                    }
                }

                public static class KernelBean {
                    /**
                     * Version : Linux version 2.6.35.3-670-g914558e+ (root@Linux-mint-32) (gcc version 4.4.4 (4.4.4_09.06.2010) ) #74 PREEMPT Wed Jun 21 16:16:57 CST 2017
                     */

                    private String Version;

                    public String getVersion() {
                        return Version;
                    }

                    public void setVersion(String Version) {
                        this.Version = Version;
                    }
                }
            }
        }

        public static class TimerTaskBean {
            /**
             * Stat : Idle
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.TimerTask.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * Stat : Working
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.SysMonitor.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * Stat : Idle
             * Senders : null
             * Connected : false
             * Enable : true
             * Users : null
             * VpnIP :
             * Name : Emd.Service.Vpn.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Connected;
            private boolean Enable;
            private Object Users;
            private String VpnIP;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isConnected() {
                return Connected;
            }

            public void setConnected(boolean Connected) {
                this.Connected = Connected;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getVpnIP() {
                return VpnIP;
            }

            public void setVpnIP(String VpnIP) {
                this.VpnIP = VpnIP;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }

        public static class MsgProcessorBean {
            /**
             * Stat : Idle
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.MsgProcessor.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * Stat : Idle
             * Senders : null
             * Enable : true
             * Users : null
             * Name : Emd.Service.PicCapture.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
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
             * Stat : Idle
             * Senders : null
             * Enable : true
             * VideoSenderTaskList : []
             * Users : null
             * Name : Emd.Service.VideoSender.E0
             */

            private String Stat;
            private Object Senders;
            private boolean Enable;
            private Object Users;
            private String Name;
            private List<?> VideoSenderTaskList;

            public String getStat() {
                return Stat;
            }

            public void setStat(String Stat) {
                this.Stat = Stat;
            }

            public Object getSenders() {
                return Senders;
            }

            public void setSenders(Object Senders) {
                this.Senders = Senders;
            }

            public boolean isEnable() {
                return Enable;
            }

            public void setEnable(boolean Enable) {
                this.Enable = Enable;
            }

            public Object getUsers() {
                return Users;
            }

            public void setUsers(Object Users) {
                this.Users = Users;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public List<?> getVideoSenderTaskList() {
                return VideoSenderTaskList;
            }

            public void setVideoSenderTaskList(List<?> VideoSenderTaskList) {
                this.VideoSenderTaskList = VideoSenderTaskList;
            }
        }
    }

    // TODO: 2017/8/11 等待实现转换
    @Override
    public DeviceStatusVO transform() {
        DeviceStatusVO deviceStatusVO = new DeviceStatusVO();
        deviceStatusVO.setDevice(this.getDevice());
        deviceStatusVO.setAgent(this.getAgent());
        deviceStatusVO.setService(this.Service);
        deviceStatusVO.setAccessServerTimeStamp(this.getAccessServerTimeStamp());
        return deviceStatusVO;
    }
}
