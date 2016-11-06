package org.jdbc.dao;

import java.util.List;

import org.jdbc.entity.User;

public interface UserDao {

	/**
	 * 閫氳繃涓婚敭鏌ヨ鐢ㄦ埛
	 * 
	 * @param uid
	 * @return 濡傛湁鑳芥煡璇㈠埌鏁版嵁锛屽垯杩斿洖鐢ㄦ埛瀵硅薄锛屽惁鍒檔ull
	 * @throws Exception
	 */
	public User findById(String uid) throws Exception;

	/**
	 * 鏌ヨ鍏ㄩ儴鐨勭敤鎴�
	 * 
	 * @return 鐢ㄦ埛瀵硅薄List
	 * @throws Exception
	 */
	public List<User> findAll() throws Exception;

	/**
	 * 鐧婚檰
	 * 
	 * @param uid
	 * @param password
	 * @return 濡傛灉鐢ㄦ埛璐︽埛瀵嗙爜鏃犺锛屽垯杩斿洖鐢ㄦ埛瀵硅薄锛屽惁鍒欒繑鍥瀗ull
	 * @throws Exception
	 */
	public User findByUidAndPassword(String uid, String password)
			throws Exception;

	/**
	 * 鏂板鐢ㄦ埛
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void insert(User user) throws Exception;

	/**
	 * 淇敼鐢ㄦ埛
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception;

	/**
	 * 閫氳繃涓婚敭鍒犻櫎鐢ㄦ埛
	 * 
	 * @param uid
	 * @throws Exception
	 */
	public void delete(String uid) throws Exception;
	
	/**
	 * 鍒犻櫎鎵�鏈夌敤鎴�
	 * 
	 * @param uid
	 * @throws Exception
	 */
	public void deleteAll() throws Exception;

}
