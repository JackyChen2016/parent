package priv.jc.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jacky
 *
 */
public class DateTime {

	/**
	 * 计算时间
	 * 
	 * @param date
	 *            日期
	 * @param field
	 *            类型 如按秒计算为： Calendar.SECOND
	 * @param amount
	 *            计算量
	 * @return
	 * @throws ExceptionF
	 *             例子：计算当前时间的前10秒的时间？ TimeCalculate(new Date(), Calendar.SECOND,
	 *             -10) 例子：计算当前时间的后10秒的时间？ TimeCalculate(new Date(),
	 *             Calendar.SECOND, 10)
	 */
	public static Date TimeCalculate(Date d, int field, int amount) {
		Date result = null;
		Calendar calendar = Calendar.getInstance(); // 得到日历
		if (d == null) {
			d = new Date();
		}
		calendar.setTime(d);// 把当前时间赋给日历
		calendar.add(field, amount); // 设置为前一天
		result = calendar.getTime(); // 得到前一天的时间
		return result;
	}

	public static long DayDifference(Date d) {
		return ((new Date().getTime() - d.getTime()) / (1000 * 60 * 60 * 24));
	}

	/**
	 * @param str:时间
	 * @param format:时间格式
	 *            y:年 M:月 d:日 H:时 m:分 s:秒
	 */
	public static Date ToDate(String str, String format) throws ParseException {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		result = sdf.parse(str);
		return result;
	}

	/**
	 * @param date:时间
	 * @param format:时间格式
	 *            y:年 M:月 d:日 H:时 m:分 s:秒
	 */
	public static String ToDate(Date date, String format) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		result = sdf.format(date);
		return result;
	}

	/**
	 * @param str:时间
	 * @param format:时间格式
	 *            y:年 M:月 d:日 H:时 m:分 s:秒
	 */
	public static String ToString(Date date, String format) throws ParseException {
		String result = null;
		result = ToDate(date, format);
		return result;
	}

	/**
	 * @param str:时间
	 * @param format:时间格式
	 *            y:年 M:月 d:日 H:时 m:分 s:秒
	 */
	public static String ToString(String str, String format) throws ParseException {
		String result = null;
		result = ToDate(ToDate(str, format), format);
		return result;
	}
}
