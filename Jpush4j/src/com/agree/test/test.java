package com.agree.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.agree.jpush.Jpush;
import com.agree.jpush.JpushClient;


public class test {
	public static void main(String[] args) {
		Logger loger = Logger.getLogger(test.class);
		System.out.println("*******************************start*****************************");
		String masterSecret = "4fd8ba046a4bb2e2f2dec407";
		String appKey = "0ce206f17b86487d1a49aab4";
//		String masterSecret = "8cfcf4ed005aeddbe646b8e8";
//		String appKey = "5517d256581a39dc28d92976";
		List ids = new ArrayList();
//		ids.add("xdm1");
//		ids.add("zhangyingwei");
		ids.add("xdm");
//		ids.add("coser");
		Map map = new HashMap();
		map.put("type","2");
		map.put("id", "1");
		List list = new ArrayList();
		list.add(Jpush.IOS);
//		list.add(Jpush.ANDROID);
//		list.add(Jpush.IOS);
//		list.add(Jpush.ANDROID);
//		String result = JpushClient.sendJmsg(masterSecret,appKey, ids, "订单通知测试", map, list, true);
		String result = JpushClient.sendJmsg(masterSecret,appKey, ids, "订单通知测试",map,list, 0);
		System.out.println(result);
		loger.info(result);
//		System.out.println(ids);
	}
}
