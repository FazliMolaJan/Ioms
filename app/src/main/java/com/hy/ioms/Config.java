package com.hy.ioms;

/**
 * app base config
 * Created by wsw on 2017/4/6.
 */

public class Config {

    public static String API_HOST = BuildConfig.API_HOST;
    public static String DEFAULT_API_HOST = BuildConfig.API_HOST;

    public static final int DEFAULT_DELAY_TIME = 30;//默认延迟时间30S
    public static final int SHORT_DELAY_TIME = 10;//默认视频查询延迟时间30S
    public static final long IMMEDIATELY_TIME = 0; //立即执行的时间

    public static final boolean LOGIN_REMEMBER_DEFAULT = true; // 默认记住登录true
    public static final int PICTURE_SPAN_COUNT_DEFAULT = 2; // 默认的图片显示列数

    public static final String ONLINE_STATE = "在线"; //在线状态
    public static final String OFFLINE_STATE = "离线";//离线状态


    //android SharedPreferences start
    public static final String SP_COOKIE = "cookie";
    public static final String SP_CSRF_TOKEN = "CSRF-TOKEN";
    public static final String SP_JSESSIONID = "JSESSIONID";
    public static final String SP_REMEMBER_ME = "remember-me";
    public static final String SP_ACCOUNT = "account";
    public static final String SP_PASSWORD = "password";
    //android SharedPreferences end

    //    page start
    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_QUERY_PAGE = 0;
    public static final String DEFAULT_SORT = "";
    public static final int DEFAULT_ITEMS_PER_PAGE = 10;
    public static final int DEFAULT_TOTAL_COUNT = Integer.MAX_VALUE;
    //    page end


    //  header start
    public static final String TOTAL_COUNT = "X-Total-Count";
    public static final String DEFAULT_CSRF_TOKEN = "";
    public static final String DEFAULT_COOKIE = "";
    public static final String DEFAULT_JSESSIONID = "";
    public static final String DEFAULT_REMEMBER_ME = "";
    //  header end

    // res name start
    public static final String ARG_SECTION_NUMBER = "arg_section_number";
    public static final String ARG_DEVICE_ID = "arg_device_id";
    public static final String ARG_DEVICE_CODE = "arg_device_code";
    public static final String ARG_DEVICE_VO = "arg_device_vo";
    public static final String ARG_ALARM_VO = "arg_alarm_vo";
    public static final String ARG_ALARM_TYPE = "arg_alarm_type";
    public static final String ALARM_FIRE = "alarm_fire";
    public static final String ALARM_BREAK = "alarm_break";
    public static final String ARG_VIDEO_TASK_ID = "arg_video_task_id";
    public static final String ARG_ALARM_TITLE = "arg_alarm_title";
    // res name end

    //device detail start
    public static final int SCHEDULE_PICTURE_SECTION_NUMBER = 0;
    public static final int MANUAL_PICTURE_SECTION_NUMBER = 1;
    //device detail end

    public static final String DEFAULT_VIDEO_CONFIG = "{\"Channel\":1,\"Nic\":\"Emd.Device.Nic.E1\",\"Camera\":\"Emd.Device.Camera.E0\",\"Protocol\":\"tcp\",\"presets\":[1,2,3]}";

    public static final String EASY_KEY = "79393674363536526D3430415753395A7074436D70655A6A6232307561486B75615735305A5778736157646C626E52746232357064473979567778576F502B6C34456468646D6C754A6B4A68596D397A595541794D4445325257467A65555268636E6470626C526C5957316C59584E35";

    public static String DEFAULT_PTZ_TYPE = "ptz";

    public static String STREAM_SERVER_HOST = "117.48.202.207";
    public static String STREAM_SERVER_PORT = "554";


}
