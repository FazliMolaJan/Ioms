package com.hy.ioms.model.dto;

import java.util.List;

/**
 * ${description}
 * Created by wsw on 2017/8/16.
 */

public class TreeNodeDTO {
    /**
     * id : 1
     * name : 四川汇源光通信有限公司
     * code : companyHy
     * type : company
     * companyId : 1
     * children : [{"id":2,"name":"四川在线研发部","code":"sectionHyResearch","type":"company","companyId":2,"children":[{"id":1,"name":"四川视频演示1","code":"circuitHy1","type":"circuit","circuitId":1,"children":[{"id":1,"name":"演示1#","code":"pole1","type":"pole","poleId":1,"children":[{"id":1,"name":"视频演示设备123","code":"HY_OLMS_000000123","type":"device","deviceId":1,"children":[]},{"id":7,"name":"L型演示设备131","code":"HY_OLMS_000000131","type":"device","deviceId":7,"children":[]},{"id":14,"name":"L型演示设备","code":"HY_OLMS_L_0000001","type":"device","deviceId":14,"children":[]},{"id":15,"name":"M型视频设备002","code":"HY_OLMS_M_0000002","type":"device","deviceId":15,"children":[]},{"id":21,"name":"HY_OLMS_000000700","code":"HY_OLMS_000000700","type":"device","deviceId":21,"children":[]},{"id":22,"name":"HY_OLMS_111111112","code":"HY_OLMS_111111112","type":"device","deviceId":22,"children":[]},{"id":23,"name":"HY_OLMS_000000705","code":"HY_OLMS_000000705","type":"device","deviceId":23,"children":[]},{"id":24,"name":"HY_OLMS_L_0000081","code":"HY_OLMS_L_0000081","type":"device","deviceId":24,"children":[]},{"id":38,"name":"HY_OLMS_L_0000063","code":"HY_OLMS_L_0000063","type":"device","deviceId":38,"children":[]},{"id":189,"name":"HY_OLMS_M_0000001","code":"HY_OLMS_M_0000001","type":"device","deviceId":189,"children":[]},{"id":196,"name":"HY_OLMS_L_TEST002","code":"HY_OLMS_L_TEST002","type":"device","deviceId":196,"children":[]},{"id":198,"name":"HY_OLMS_000000701","code":"HY_OLMS_000000701","type":"device","deviceId":198,"children":[]}]},{"id":2,"name":"演示2#","code":"pole2","type":"pole","poleId":2,"children":[{"id":2,"name":"视频演示设备124","code":"HY_OLMS_000000124","type":"device","deviceId":2,"children":[]},{"id":8,"name":"L型设备002","code":"HY_OLMS_L_0000002","type":"device","deviceId":8,"children":[]},{"id":16,"name":"M型视频设备003","code":"HY_OLMS_M_0000003","type":"device","deviceId":16,"children":[]}]}]},{"id":2,"name":"四川图片演示1","code":"circuitHy2","type":"circuit","circuitId":2,"children":[{"id":3,"name":"演示3#","code":"pole3","type":"pole","poleId":3,"children":[{"id":3,"name":"视频演示设备125","code":"HY_OLMS_000000125","type":"device","deviceId":3,"children":[]},{"id":9,"name":"L型设备003","code":"HY_OLMS_L_0000003","type":"device","deviceId":9,"children":[]},{"id":17,"name":"L型设备006","code":"HY_OLMS_L_0000006","type":"device","deviceId":17,"children":[]},{"id":190,"name":"HY_OLMS_L_0000064","code":"HY_OLMS_L_0000064","type":"device","deviceId":190,"children":[]},{"id":191,"name":"HY_OLMS_L_0000038","code":"HY_OLMS_L_0000038","type":"device","deviceId":191,"children":[]}]},{"id":4,"name":"演示4#","code":"pole4","type":"pole","poleId":4,"children":[{"id":10,"name":"L型设备004","code":"HY_OLMS_L_0000004","type":"device","deviceId":10,"children":[]}]}]},{"id":3,"name":"四川图片演示2","code":"circuitHy3","type":"circuit","circuitId":3,"children":[{"id":5,"name":"演示5#","code":"pole5","type":"pole","poleId":5,"children":[{"id":11,"name":"L型设备005","code":"HY_OLMS_L_0000005","type":"device","deviceId":11,"children":[]},{"id":18,"name":"HY_OLMS_L_0000001","code":"HY_OLMS_L_0000001","type":"device","deviceId":18,"children":[]}]}]},{"id":21,"name":"外破测试","code":"zoujun","type":"circuit","circuitId":21,"children":[{"id":29,"name":"###","code":"0000","type":"pole","poleId":29,"children":[{"id":247,"name":"HY_OLMS_L_0000159","code":"HY_OLMS_L_0000159","type":"device","deviceId":247,"children":[]},{"id":248,"name":"HY_OLMS_L_0000160","code":"HY_OLMS_L_0000160","type":"device","deviceId":248,"children":[]},{"id":250,"name":"HY_OLMS_L_0000161","code":"HY_OLMS_L_0000161","type":"device","deviceId":250,"children":[]}]}]}]},{"id":17,"name":"三跨视频研发17012","code":"17012","type":"company","companyId":17,"children":[{"id":18,"name":"YS2017012","code":"17012","type":"circuit","circuitId":18,"children":[{"id":26,"name":"###","code":"17012","type":"pole","poleId":26,"children":[{"id":231,"name":"HY_OLMS_YS_000025","code":"HY_OLMS_YS_000025","type":"device","deviceId":231,"children":[]},{"id":235,"name":"HY_TEST_RHT011112","code":"HY_TEST_RHT011112","type":"device","deviceId":235,"children":[]}]}]}]}]
     */

    private int id;
    private String name;
    private String code;
    private String type;
    private List<TreeNodeDTO> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TreeNodeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeDTO> children) {
        this.children = children;
    }
}
