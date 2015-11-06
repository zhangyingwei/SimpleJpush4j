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
	 * ����ƽ̨������
	 * ���Ͷ�������
	 * �������ݣ�alert
	 * @param alert
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }
	
	/**
	 * ����ƽ̨������
	 * ����Ŀ�꣺���б���Ϊalias��Ŀ��
	 * �������ݣ�alset
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
	 * ����ƽ̨������
	 * ����Ŀ�꣺���б�ǩΪtag��Ŀ��
	 * �������ݣ�alert
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
	 * ����ƽ̨����׿
	 * ����Ŀ�꣺���б�ǩΪtag��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
	 * ����ƽ̨��IOS
	 * ����Ŀ�꣺���б�ǩΪtag��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
	 * ����ƽ̨����׿
	 * ����Ŀ�꣺���б���Ϊaliases��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
	 * ����ƽ̨����׿
	 * ����Ŀ�꣺���б���Ϊaliases��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
	 * ����ƽ̨��IOS
	 * ����Ŀ�꣺���б���Ϊaliases��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
	 * ����ƽ̨��IOS
	 * ����Ŀ�꣺���б���Ϊaliases��Ŀ��
	 * �������ݣ�alert
	 * ���ͱ��⣺title
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
