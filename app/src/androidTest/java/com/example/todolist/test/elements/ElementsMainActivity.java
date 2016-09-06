package com.example.todolist.test.elements;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.todolist.R;
import com.robotium.solo.Solo;

public class ElementsMainActivity {
	
	private Solo solo;
	private ListView toDoListView;
	private LinearLayout emptyToDoView;

	
	public ElementsMainActivity(Solo solo){
		this.solo = solo;
		initViews();
	}
	
	/**
	 * 初始化的时候，找到所有登录页面的控件
	 */
	private void initViews(){
		toDoListView = (ListView) solo.getCurrentActivity().findViewById(R.id.todoListView);
		emptyToDoView = (LinearLayout) solo.getCurrentActivity().findViewById(R.id.emptyToDoView);
	}
	
	public ListView getToDoListView(){
		return toDoListView;
	}

    public void clickNewToDoList(){
        solo.sendKey(Solo.MENU);
        solo.clickOnText("新建待办事项");
    }
	


}
