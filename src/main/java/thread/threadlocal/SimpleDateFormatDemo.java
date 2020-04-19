package thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat 不是线程安全胡
 */
public class SimpleDateFormatDemo {

	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public String formatIt(Date date) {
		return formatter.get().format(date);
	}

	/**
	 * 另一种安全使用SimpleDateFormat 的方式
	 */
	public Date convertStringToDate(String dateString) throws ParseException {
		SimpleDateFormat df = null;
		Date result;
		synchronized (df) {
			result = df.parse(dateString);
		}
		return result;
	}
}
