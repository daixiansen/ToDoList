package com.example.todolist.test.testcases;

import com.example.todolist.test.BasicTestCaseWithLogin;
import com.example.todolist.test.utils.Util;

public class CrossAPPTest extends BasicTestCaseWithLogin {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testCrossAPPTest() {
		Util.sendUIAutomatorRequestWithParams("CrossAPP1", "testCrossAPP1_1", "ToDoList");
		Util.sendUIAutomatorRequestWithParams("CrossAPP1", "testCrossAPP1_2", "ToDoList");
	}

}
