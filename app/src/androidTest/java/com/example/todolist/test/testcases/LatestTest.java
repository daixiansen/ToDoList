package com.example.todolist.test.testcases;

import java.io.File;

import com.example.todolist.test.BasicTestCase;

public class LatestTest extends BasicTestCase {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		File file = new File("mnt/sdcard/testauto/crash.txt");
		if (file.exists())
			file.delete();
	}

	public void testNothing(){
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

}
