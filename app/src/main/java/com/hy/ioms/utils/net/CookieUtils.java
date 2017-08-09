package com.hy.ioms.utils.net;

import android.content.SharedPreferences;

import com.hy.ioms.Config;

/**
 * Created by wsw on 2017/4/14.
 */

public class CookieUtils {

    public static String saveCookie(SharedPreferences sharedPreferences) {
        StringBuilder cookieBuilder = new StringBuilder();
        cookieBuilder.append("CSRF-TOKEN=").append(sharedPreferences.getString(Config
                .SP_CSRF_TOKEN, "")).append(";");
        cookieBuilder.append("JSESSIONID=").append(sharedPreferences.getString(Config
                .SP_JSESSIONID, "")).append(";");
        cookieBuilder.append("remember-me=").append(sharedPreferences.getString(Config
                .SP_REMEMBER_ME, "")).append(";");
        String cookie = cookieBuilder.toString();
        sharedPreferences.edit().putString(Config.SP_COOKIE, cookie).apply();
        return cookie;
    }


    public static String getCookie(String csrfToken, String jsessionid, String rememberMe) {
        return "CSRF-TOKEN=" + csrfToken + ";" +
                "JSESSIONID=" + jsessionid + ";" +
                "remember-me=" + rememberMe + ";";
    }
}
