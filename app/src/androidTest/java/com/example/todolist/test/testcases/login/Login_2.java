package com.example.todolist.test.testcases.login;

import com.example.todolist.test.BasicTestCase;

public class Login_2 extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogin_2() {
		uiHelper.getElementsLoginActivity().clickLoginButton();
//	    android.os.Process.killProcess(android.os.Process.myPid());
		//点击登录按钮
		assertTrue("错误提示信息没有出现,可能出现BUG.",uiHelper.getSolo().searchText("用户名或者密码不能为空！", true));
	}

}
