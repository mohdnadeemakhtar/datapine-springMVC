package com.datapine.dao;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.datapine.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final int FIRST_INDEX = 0;
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("datapine");
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager;
	}

	@PersistenceContext(name = "datapine")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		if (null != user) {
			getEntityManager();
			entityManager.persist(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
		}
	}

	@Override
	public boolean updateUser(User user) {
		if (null != user) {
			getEntityManager();
			entityManager.merge(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(Long id) {
		getEntityManager();
		User user = entityManager.find(User.class, id);
		if (null != user) {
			entityManager.remove(user);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(Long id) {
		User user = (User) entityManager.createNamedQuery("findById")
				.setParameter("id", id).getSingleResult();
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Iterator<User> findAllOrderById() {
		List<User> list = entityManager.createNamedQuery("findAllUser")
				.getResultList();
		Iterator<User> iterator = list.iterator();
		return iterator;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User login(User user) {
		List<User> list = entityManager
				.createNamedQuery("findByEmailAndPassword")
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword()).getResultList();

		if (0 != list.size()) {
			return list.get(FIRST_INDEX);
		}
		return null;
	}

	@Override
	public boolean logout() {
		if (entityManager.isOpen()) {
			entityManager.clear();
			entityManager.close();
			return true;
		}
		return false;
	}

}
