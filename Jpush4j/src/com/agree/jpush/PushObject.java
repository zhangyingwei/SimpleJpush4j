package com.agree.jpush;

import java.util.List;
import java.util.Map;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushObject {
	
	/**
	 * 推送平台：所有
	 * 推送对象：所有
	 * 推送内容：alert
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }
	
	/**
	 * 推送平台：所有
	 * 推送目标：所有别名为alias的目标
	 * 推送内容：alset
	 * @param alias
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert(String alias,String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }
	/**
	 * 推送平台：所有
	 * 推送目标：所有标签为tag的目标
	 * 推送内容：alert
	 * @param tags
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_all_tags_alert(List tags,String alert) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.tag(tags))
				.setNotification(Notification.alert(alert))
				.build();
	}
	
	/**
	 * 推送平台：安卓
	 * 推送目标：所有标签为tag的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param tag
	 * @param alert
	 * @param title
	 * @return
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle(List tags,String alert,String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tags))
                .setNotification(Notification.android(alert, title, null))
                .build();
    }
	/**
	 * 推送平台：IOS
	 * 推送目标：所有标签为tag的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param tag
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_ios_tag_alertWithTitle(List tags,String alert) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag(tags))
				.setNotification(Notification.ios(alert, null))
				.build();
	}
	
	/**
	 * 推送平台：安卓
	 * 推送目标：所有别名为aliases的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param aliases
	 * @param alert
	 * @param title
	 * @return
	 */
	public static PushPayload buildPushObject_android_aliases_alertWithTitle(List aliases,String alert,String title) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.alias(aliases))
                .setNotification(Notification.android(alert, title, null))
                .build();
    }
	/**
	 * 推送平台：安卓
	 * 推送目标：所有别名为aliases的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param aliases
	 * @param alert
	 * @param title
	 * @return
	 */
	public static PushPayload buildPushObject_android_aliases_alertWithTitleWithExtra(List aliases,String alert,String title,Map extra) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.alias(aliases))
				.setNotification(Notification.android(alert, title, extra))
				.build();
	}
	/**
	 * 推送平台：IOS
	 * 推送目标：所有别名为aliases的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param aliases
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_ios_aliases_alert(List aliases,String alert) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.alias(aliases))
				.setNotification(Notification.ios(alert, null))
				.build();
	}
	/**
	 * 推送平台：IOS
	 * 推送目标：所有别名为aliases的目标
	 * 推送内容：alert
	 * 推送标题：title
	 * @param aliases
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_ios_aliases_alertWithExtra(List aliases,String alert,Map extra) {
		return PushPayload.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.alias(aliases))
				.setNotification(Notification.ios(alert, extra))
				.build();
	}
}
