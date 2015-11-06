package com.agree.jpush;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.model.PushPayload;

public class JpushClient {
	//发送极光推送
		public static String sendJmsg(String mastersecret,String appkey,List aligns,String message,Map extra ,List OsType,int each){
			JPushClient jPushClient = new JPushClient(mastersecret, appkey, 3);
			Map resultMap = new HashMap();
//			Map extra = new HashMap();
			List resultAligns_s = new ArrayList();
			List resultAligns_f = new ArrayList();
			List resultOsType_s = new ArrayList();
			List resultOsType_f = new ArrayList();
			String errcode = "";//失败码
			String errmsg = "";//失败消息
			if(each==1){
				System.out.println("@each");
				for(int i = 0;i<aligns.size();i++){
					if(OsType.get(i)==null||OsType.get(i).equals(null)){
						continue;
					}
					List align = new ArrayList();
					align.add(aligns.get(i));
					PushPayload payload_android = null;
					PushPayload payload_ios = null;
					if(Jpush.ANDROID.equals(OsType.get(i))){
						payload_android = PushObject.buildPushObject_android_aliases_alertWithTitleWithExtra(align, message,"", extra);
					}else if(Jpush.IOS.equals(OsType.get(i))){
						payload_ios = PushObject.buildPushObject_ios_aliases_alertWithExtra(align, message, extra);
					}else if(Jpush.ALL_OS.equals(OsType.get(i))){
						payload_android = PushObject.buildPushObject_android_aliases_alertWithTitleWithExtra(align, message,"", extra);
						payload_ios = PushObject.buildPushObject_ios_aliases_alertWithExtra(align, message, extra);
					}
					try {
						if(payload_android!=null){
							jPushClient.sendPush(payload_android);
						}
						if(payload_ios!=null){
							jPushClient.sendPush(payload_ios);
						}
						
						resultAligns_s.add(aligns.get(i));
						resultOsType_s.add(OsType.get(i));
						errcode = "000000";
						errmsg = "成功";
					} catch (APIConnectionException e) {
						System.out.println(e.getMessage());
						resultAligns_f.add(aligns.get(i));
						resultOsType_f.add(OsType.get(i));
						errcode = "000001";
						errmsg = e.getMessage();
					} catch (APIRequestException e) {
						System.out.println(e.getMessage());
						resultAligns_f.add(aligns.get(i));
						resultOsType_f.add(OsType.get(i));
						errcode = "000002";
						errmsg = JSONObject.fromObject(JSONObject.fromObject(e.getMessage()).get("error")).get("message").toString();
					}catch(Exception e){
						System.out.println(e.getMessage());
						resultAligns_f.add(aligns.get(i));
						resultOsType_f.add(OsType.get(i));
						errcode = "000003";
						errmsg = e.getMessage();
					}
				}
			}else{
				PushPayload payload_android = null;
				PushPayload payload_ios = null;
				if(OsType.size()==0||OsType==null){
					return JSONObject.fromObject(resultMap).toString();
				}else if(OsType.get(0)==null||OsType.get(0).equals(null)){
					return JSONObject.fromObject(resultMap).toString();
				}
				if(Jpush.ANDROID.equals(OsType.get(0))){
					payload_android = PushObject.buildPushObject_android_aliases_alertWithTitleWithExtra(aligns, message,"", extra);
				}else if(Jpush.IOS.equals(OsType.get(0))){
					payload_ios = PushObject.buildPushObject_ios_aliases_alertWithExtra(aligns, message, extra);
				}else if(Jpush.ALL_OS.equals(OsType.get(0))){
					payload_android = PushObject.buildPushObject_android_aliases_alertWithTitleWithExtra(aligns, message,"", extra);
					payload_ios = PushObject.buildPushObject_ios_aliases_alertWithExtra(aligns, message, extra);
				}
				try {
					if(payload_android!=null){
						jPushClient.sendPush(payload_android);
					}
					if(payload_ios!=null){
						jPushClient.sendPush(payload_ios);
					}
					resultAligns_s.addAll(aligns);
					resultOsType_s.add(OsType);
					errcode = "000000";
					errmsg = "成功";
				} catch (APIConnectionException e) {
					resultAligns_f.addAll(aligns);
					resultOsType_f.add(OsType);
					errcode = "000001";
					errmsg = e.getMessage();
				} catch (APIRequestException e) {
					resultAligns_f.addAll(aligns);
					resultOsType_f.add(OsType);
					errcode = "000002";
					errmsg = JSONObject.fromObject(JSONObject.fromObject(e.getMessage()).get("error")).get("message").toString();
				}catch(Exception e){
					resultAligns_f.addAll(aligns);
					resultOsType_f.add(OsType);
					errcode = "000003";
					errmsg = e.getMessage();
				}
			}
			if(resultAligns_s.size()!=0){
				resultMap.put("flag", 0);
			}else{
				resultMap.put("flag", 1);
			}
			resultMap.put("aligns_s", resultAligns_s);
			resultMap.put("ostype_s", resultOsType_s);
			resultMap.put("aligns_f", resultAligns_f);
			resultMap.put("ostype_f", resultOsType_f);
			resultMap.put("errcode", errcode);
			resultMap.put("errmsg", errmsg);
			return JSONObject.fromObject(resultMap).toString();
		}
}
