package com.hy.ioms;

import com.google.gson.Gson;
import com.hy.ioms.model.dto.OperateDTO;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by wsw on 2017/8/9.
 */

public class JsonTest {

    Gson gson;

    @Before
    public void setUp() {
        gson = new Gson();
    }

    @Test
    public void testOperate() {
        HashMap<String, Object> parms = new HashMap<>();
        parms.put("OpenTimeSpan", 10);
        parms.put("In", "ceshi");

        String json = gson.toJson(new OperateDTO(new OperateDTO.DestInfo("Emd.Device.Camera.E0",
                "Open", "Emd.Method.Normal")));
        System.out.println(json);

    }


}
