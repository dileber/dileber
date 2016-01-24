package com.zhonghua.dileber.app;


import android.app.Application;
import android.content.Context;
import com.zhonghua.dileber.http.CacheConfig;
import com.zhonghua.dileber.tools.SLog;

public class SApplication extends Application{

	private static SApplication instance;
	private static Context context;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
		context = instance.getApplicationContext();
		CacheConfig.initCacheConfig(context);
	}
	
	public static Context getAppContext() {
		return context;
	}

	public static SApplication getInstance() {
		return instance;
	}

	
	/**
	 * 输出log 日志
	 * 
	 * @param bug true or false
	 * @param bugName tag
	 */
	protected void buglog(boolean bug,String bugName){
		SLog.tag = bugName; // 方便调试时过滤 adb logcat 输出
		SLog.info = bug; //关闭 LogUtils.i(...) 的 adb log 输出
	}
	
}
