package com.example.todolist.test.testcases.login;

import com.example.todolist.test.BasicTestCaseWithLogin;
import com.robotium.solo.Solo;

public class Login_3 extends BasicTestCaseWithLogin {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogin_3() {
		uiHelper.getSolo().sleep(2000);
        uiHelper.getSolo().sendKey(Solo.MENU);
		assertTrue(uiHelper.getSolo().searchText("新建待办事项",true));
	}

}
