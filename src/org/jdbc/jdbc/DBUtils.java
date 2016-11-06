package org.jdbc.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 鏁版嵁搴撳伐鍏风被
 */
abstract public class DBUtils {

	/**
	 * 鑾峰彇鏁版嵁搴撹繛鎺�
	 */
	public static Connection getConnection() throws Exception {
		Properties pps = new Properties();
		pps.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc/database.properties"));
		String DRIVER = pps.getProperty("DRIVER");
		String DB_URL = pps.getProperty("DB_URL");
		String USER = pps.getProperty("USER");
		String PWD = pps.getProperty("PWD");

		Class.forName(DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PWD);
	}

	/**
	 * 灏哛esultSet杞寲涓篊lazz鐨勫疄渚嬪璞ist锛屽墠鎻愭槸Clazz鐨勫睘鎬у悕鍜屾煡璇㈢殑鍒楁槑瑕佹兂鐩稿悓锛屽睘鎬у繀椤诲叏閮ㄦ槸String绫诲瀷
	 * 
	 * @param rs
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> convertResultSetToInstanceList(ResultSet rs, Class<T> clazz) throws Exception {
		List<T> list = new ArrayList<>();
		T instance = null;
		while ((instance = convertResultSetToInstance(rs, clazz)) != null) {
			list.add(instance);
		}
		return list;
	}

	/**
	 * 灏哛esultSet杞寲涓篊lazz鐨勫疄渚嬪璞★紝鍓嶆彁鏄疌lazz鐨勫睘鎬у悕鍜屾煡璇㈢殑鍒楀悕瑕佹兂鐩稿悓锛屽睘鎬у繀椤诲叏閮ㄦ槸String绫诲瀷
	 * 
	 * @param rs
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T convertResultSetToInstance(ResultSet rs, Class<T> clazz) throws Exception {
		if (!rs.next()) {
			return null;
		}

		ResultSetMetaData meta = rs.getMetaData();
		T intance = clazz.newInstance();

		for (int i = 1; i <= meta.getColumnCount(); i++) {
			String colName = meta.getColumnName(i);
			String colValue = rs.getString(i);

			Field field = clazz.getDeclaredField(colName);
			field.setAccessible(true);
			field.set(intance, colValue);
			field.setAccessible(false);
		}

		return intance;
	}

}
