package com.example.todolist.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.todolist.LoginActivity;
import com.robotium.solo.Solo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Description ${TODO}
 * Author daiyongxin
 * Date   2016/9/9 16:19
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    private Solo solo;

    public MainActivityTest() {
        super(LoginActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Test
    public void testShowText() {
        Assert.assertTrue(solo.searchText("登入"));
    }
}
