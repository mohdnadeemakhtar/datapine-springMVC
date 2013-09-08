package com.datapine.dao;

import java.util.Iterator;

import com.datapine.domain.User;


/**
 * Declares methods used to communicate with data layer.
 * @author Mohd Nadeem Akhtar
 */
public interface UserDAO {

	/**
	 * Requires user object for Authentication.
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * Saves user object after registration process.
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * Update the user information. Requires user object.
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	/**
	 * Retrieve the User with id and remove it completely from database.
	 * @param id
	 * @return
	 */
	public boolean deleteUser(Long id);
	
	/**
	 * Clean up the entity manager class and notify the controller before logout.
	 * @return
	 */
	public boolean logout();
	
	/**
	 * Retrieve User object with id
	 * @param id
	 * @return
	 */
	public User getUserById(Long id);
	
	/**
	 * Return all the users which should be ordered by Id
	 * @return
	 */
	public Iterator<User> findAllOrderById();

}
