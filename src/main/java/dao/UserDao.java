
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dto.User;
public class UserDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void send(User user)
	{
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	public User find(String email)
	{
		return entityManager.find(User.class, email);
	}
	public List<User> fetchAll()
	{
		return entityManager.createQuery("Select x from User x").getResultList();
	}
	public void delete(User user)
	{
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}
	public void updateUser(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
}
