package com.example.todolist.test;


abstract public class BasicTestCaseWithLogin extends
		BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		uiHelper.getElementsLoginActivity().doLoginWithAccount(new String[]{"1","1"});
	}
	
}
