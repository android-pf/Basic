package com.futurenavi.libbasic.utils;


public class IntentForKey {
	
	/** 状态跳转 */
	//登录页面的返回类型
	public static final String BACK_TYPE = "back_type";
		//在首页返回的时候不结束当前的activity
	public static final int  AT_MAIN = 0;
		//在首页返回的时候结束当前的activity
	public static final int  AT_NOT_MAIN = 1;
		//在验证的时候返回到登录(进行fragment退栈操作)
	public static final int  AT_VERIFY = 2;



	public static final String FRAGMENT = "Fragment";
}
