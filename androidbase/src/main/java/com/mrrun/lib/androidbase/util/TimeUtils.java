package com.mrrun.lib.androidbase.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>类功能描述:</b><br>
 * 时间工具类<br>
 * 
 * @author lipin
 * @version 1.0
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtils {

	/**
	 * 如:yyyy-MM-dd HH:mm:ss
	 */
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private TimeUtils() {
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 时间毫秒转化成特定格式的字符串时间
	 * 
	 * @param timeInMillis
	 *            毫秒
	 * @param dateFormat
	 *            指定格式
	 * @return String 特定格式的字符串时间
	 */
	public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
		return dateFormat.format(new Date(timeInMillis));
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 时间毫秒转化成特定格式的字符串时间,指定格式是{@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @param timeInMillis
	 *            毫秒
	 * @return String 特定格式的字符串时间
	 */
	public static String getTime(long timeInMillis) {
		return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 获得当前时间， 以毫秒为单位
	 * 
	 * @return long 毫秒
	 */
	public static long getCurrentTimeInLong() {
		return System.currentTimeMillis();
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 获得当前时间,指定格式是 {@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @return String 特定格式的字符串时间
	 */
	public static String getCurrentTimeInString() {
		return getTime(getCurrentTimeInLong());
	}

	/**
	 * <b>方法功能描述:</b><br>
	 * 获得当前时间，以毫秒为单位
	 * 
	 * @param dateFormat
	 *            指定格式
	 * @return String 特定格式的字符串时间
	 */
	public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {

		return getTime(getCurrentTimeInLong(), dateFormat);
	}
}