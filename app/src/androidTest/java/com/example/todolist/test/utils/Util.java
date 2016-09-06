package com.example.todolist.test.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.todolist.test.ConnectionProperty;

import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class Util {

	/**
	 * wake up screen if needed
	 * 
	 * @param owner
	 * @return return wakeLock object,it will release after class done
	 */
	public static WakeLock wakeScreen(InstrumentationTestCase owner) {
		PowerManager pm = (PowerManager) owner.getInstrumentation()
				.getTargetContext().getSystemService(Context.POWER_SERVICE);
		WakeLock wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
				| PowerManager.FULL_WAKE_LOCK
				| PowerManager.ACQUIRE_CAUSES_WAKEUP, owner.getClass()
				.getSimpleName());
		wakeLock.acquire();
		return wakeLock;
	}

	public static void unlock(Instrumentation instr) {
		try {
			Context targetContext = instr.getTargetContext();
			KeyguardManager keyGuardManager = (KeyguardManager) targetContext
					.getSystemService(Context.KEYGUARD_SERVICE);
			KeyguardLock mLock = keyGuardManager.newKeyguardLock("");
			mLock.disableKeyguard();
		} catch (Throwable e) {
			Log.e("", "disableKeyguard:", e);
		}
	}
	
	 public static void sendUIAutomatorRequestWithParams(String caseId,String methodName,String extraParams){
         if("".equals(caseId) || "".equals(methodName)){
              Assert.fail("caseId or methodName was not set!");
         }
         List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>(); 
         params.add(new BasicNameValuePair("caseId", caseId)); 
         params.add(new BasicNameValuePair("methodName", methodName)); 
         params.add(new BasicNameValuePair("params",extraParams));
         params.add(new BasicNameValuePair("deviceId",ConnectionProperty.DEVICE_ID));
         String param = URLEncodedUtils.format(params, "UTF-8"); 
         HttpGet getMethod = new HttpGet(ConnectionProperty.SERVER_URL + "?" + param); 
         HttpClient httpClient = new DefaultHttpClient(); 
         try { 
             HttpResponse response = httpClient.execute(getMethod);
             InputStream in = response.getEntity().getContent();
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            if("Fail".equals(reader.readLine())){
                 Assert.fail("Service side return errors.");
            }
         } catch (ClientProtocolException e) { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         } catch (IOException e) { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         } 
    }

}