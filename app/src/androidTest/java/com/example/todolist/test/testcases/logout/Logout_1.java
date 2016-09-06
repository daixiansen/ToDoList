package com.example.todolist.test.testcases.logout;

import com.example.todolist.test.BasicTestCaseWithLogin;
import com.robotium.solo.Solo;

public class Logout_1 extends BasicTestCaseWithLogin {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogout_1() {
		uiHelper.getSolo().sendKey(Solo.MENU);
		uiHelper.getSolo().sleep(3000);
		uiHelper.getSolo().clickOnText("退出");
		uiHelper.getSolo().clickOnButton("确定");
		assertEquals("",uiHelper.getElementsLoginActivity().getNameEditText().getText().toString());
		assertEquals("",uiHelper.getElementsLoginActivity().getPasswordEditText().getText().toString());
	}

}
