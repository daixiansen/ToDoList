package com.example.todolist.test.testcases.todolist;

import com.example.todolist.MainActivity;
import com.example.todolist.test.BasicTestCaseWithLogin;

public class ToDoList_2 extends BasicTestCaseWithLogin {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testToDoList_1() {
		uiHelper.getElementsMainActivity().clickNewToDoList();
		uiHelper.getElementsNewToDoActivity().enterTextToToDoItemDetailET("addtest");
		uiHelper.getElementsNewToDoActivity().clickSaveButton();
		uiHelper.getSolo().waitForActivity(MainActivity.class,3000);
		assertTrue(uiHelper.getSolo().searchText("addtest", true));
		uiHelper.getSolo().clickLongOnText("addtest");
		uiHelper.getSolo().clickOnText("删除");
		uiHelper.getSolo().clickOnButton("确定");
		assertFalse(uiHelper.getSolo().searchText("addtest", true));
	}

}
