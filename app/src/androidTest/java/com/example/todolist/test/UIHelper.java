package com.example.todolist.test;

import com.example.todolist.test.elements.ElementsEditToDoItemActivity;
import com.example.todolist.test.elements.ElementsLoginActivity;
import com.example.todolist.test.elements.ElementsMainActivity;
import com.example.todolist.test.elements.ElementsNewToDoActivity;
import com.robotium.solo.Solo;

public class UIHelper {
	private Solo solo = null;
	private ElementsLoginActivity elementsLoginActivity;
	private ElementsMainActivity elementsMainActivity;
	private ElementsNewToDoActivity elementsNewToDoActivity;
	private ElementsEditToDoItemActivity elementsEditToDoItemActivity;

	public UIHelper(Solo solo) {
		this.solo = solo;
	}

	public Solo getSolo() {
		return solo;
	}

	public ElementsLoginActivity getElementsLoginActivity() {
		elementsLoginActivity = new ElementsLoginActivity(solo);
		return elementsLoginActivity;
	}

	public ElementsMainActivity getElementsMainActivity() {
		elementsMainActivity = new ElementsMainActivity(solo);
		return elementsMainActivity;
	}

	public ElementsNewToDoActivity getElementsNewToDoActivity() {
		elementsNewToDoActivity = new ElementsNewToDoActivity(solo);
		return elementsNewToDoActivity;
	}

	public ElementsEditToDoItemActivity getElementsEditToDoItemActivity() {
		elementsEditToDoItemActivity = new ElementsEditToDoItemActivity(solo);
		return elementsEditToDoItemActivity;
	}
}
