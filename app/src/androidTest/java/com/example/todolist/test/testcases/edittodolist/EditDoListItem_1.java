package com.example.todolist.test.testcases.edittodolist;

import com.example.todolist.EditToDoItemActivity;
import com.example.todolist.MainActivity;
import com.example.todolist.test.BasicTestCaseWithLogin;

public class EditDoListItem_1 extends BasicTestCaseWithLogin {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testEditDoListItem_1() {
		uiHelper.getElementsMainActivity().clickNewToDoList();
		uiHelper.getElementsNewToDoActivity().enterTextToToDoItemDetailET("testedti");
		uiHelper.getElementsNewToDoActivity().clickSaveButton();
		//还没编辑前应该search不到这个文本testedit
		assertFalse(uiHelper.getSolo().waitForText("testedit", 1, 2000, false, true));
		uiHelper.getSolo().clickLongOnText("testedti");
		uiHelper.getSolo().clickOnText("编辑");
		//验证编辑页面打开
		assertTrue(uiHelper.getSolo().waitForActivity(EditToDoItemActivity.class,3000));
		//验证编辑框中的内容为testedti
		assertEquals("testedti",uiHelper.getElementsEditToDoItemActivity().getToDoItemDetailET().getText().toString());
		//情况编辑框中的数据
		uiHelper.getElementsEditToDoItemActivity().clearToDoItemDetailET();
		//添加新的数据
		uiHelper.getElementsEditToDoItemActivity().enterTextToToDoItemDetailET("testedit");
		uiHelper.getElementsEditToDoItemActivity().clickSaveButton();
		//验证回到任务列表页面
		assertTrue(uiHelper.getSolo().waitForActivity(MainActivity.class,3000));
		//验证文本被成功update
		assertTrue(uiHelper.getSolo().searchText("testedit", true));
	}

}
