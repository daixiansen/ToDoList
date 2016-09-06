package com.example.todolist.test.testcases.login;

import com.example.todolist.test.BasicTestCase;

public class Login_1 extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogin_1() {
		uiHelper.getSolo().sleep(2000);
		//在用户名输入框输入abcdef
		uiHelper.getElementsLoginActivity().enterName("abcdef");
		//子密码卡输入123456
		uiHelper.getElementsLoginActivity().enterPassword("123456");
		//点击登录按钮
		uiHelper.getElementsLoginActivity().clickLoginButton();
		//点击登录按钮
		assertTrue("错误提示信息没有出现,可能出现BUG.",uiHelper.getSolo().searchText("用户名或者密码错误！", true));
	}

}
