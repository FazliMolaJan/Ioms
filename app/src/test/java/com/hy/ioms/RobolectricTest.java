package com.hy.ioms;

import android.text.TextUtils;

import com.hy.ioms.view.login.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * ${description}
 * Created by wsw on 2017/8/15.
 */
@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {
    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {

        if(TextUtils.isEmpty("167")){
            throw new Exception("error");
        }else{
            System.out.println("not");
        }
    }
}
