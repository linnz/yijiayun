package org.jdbc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jdbc.entity.User;

public class UserDaoJpaImpl implements UserDao {

	private EntityManager em = Persistence.createEntityManagerFactory("jpaDemo").createEntityManager();

	@Override
	public User findById(String uid) throws Exception {
		return em.find(User.class, uid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		return em.createQuery("from User").getResultList();
	}

	public long count() {
		String hql = "select count(*) from User";
		Query query = em.createQuery(hql);
		return (long) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUidAndPassword(String uid, String password) throws Exception {
		String hql = "from User where uid = :uid and password = :password";
		Query query = em.createQuery(hql);
		query.setParameter("uid", uid);
		query.setParameter("password", password);
		List<User> user = query.getResultList();
		return user.isEmpty() ? null : user.get(0);
	}

	@Override
	public void insert(User user) throws Exception {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	@Override
	public void update(User user) throws Exception {
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	@Override
	public void delete(String uid) throws Exception {
		em.getTransaction().begin();
		User user = em.find(User.class, uid); // 此种方法删除uid的用户会抛出异常
		em.remove(user);
		em.getTransaction().commit();
	}

	@Override
	public void deleteAll() throws Exception {
		em.getTransaction().begin();
		em.createQuery("delete from User").executeUpdate();
		em.getTransaction().commit();
	}

}
