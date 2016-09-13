package cn.v6.sixrooms;

import android.app.Activity;
import com.robotium.recorder.executor.Executor;

@SuppressWarnings("rawtypes")
public class SplashActivityExecutor extends Executor {

	@SuppressWarnings("unchecked")
	public SplashActivityExecutor() throws Exception {
		super((Class<? extends Activity>) Class.forName("cn.v6.sixrooms.ui.phone.SplashActivity"),  "cn.v6.sixrooms.R.id.", new android.R.id(), false, false, "1473308366816");
	}

	public void setUp() throws Exception { 
		super.setUp();
	}
}
