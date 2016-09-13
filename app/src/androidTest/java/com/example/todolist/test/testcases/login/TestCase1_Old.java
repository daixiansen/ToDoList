package com.example.todolist.test.testcases.login;

import android.test.ActivityInstrumentationTestCase2;

import com.example.todolist.LoginActivity;
import com.robotium.solo.Solo;

public class TestCase1_Old extends ActivityInstrumentationTestCase2<LoginActivity> {
	private Solo solo;

	public TestCase1_Old() {
		super(LoginActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testTestCase1() {
		//在用户名输入框输入abcdef
		solo.enterText(0, "abcdef");
		//子密码卡输入123456
		solo.enterText(1, "12345678");
		//点击登录按钮
		solo.clickOnButton(0);
		//点击登录按钮
		assertTrue("错误提示信息没有出现,可能出现BUG.",solo.searchText("用户名或者密码错误！", true));
	}

	@Override
	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
}
