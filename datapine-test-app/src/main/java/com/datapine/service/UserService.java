package com.datapine.service;

import java.util.Iterator;
import com.datapine.domain.User;


/**
 * Declares methods used to obtain and modify User information.
 * @author Mohd Nadeem Akhtar
 */
public interface UserService {

	/**
	 * Register new User
	 * @param email
	 * @param password
	 * @return
	 */
	public User register(String email, String password, String userName, String gender);
	
	/**
	 * Login user with email and password
	 * @param email
	 * @param password
	 * @return
	 */

	public User login(String email, String password);
	
	/**
	 * Returns a list of users present in database with no relation.
	 * @return
	 */
	public Iterator<User> listOfUsers();
	
	/**
	 * User needs to provide old password and userId to Update password.
	 * Currently no password constrains are applied.
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */

	public User updatePassword(Long userId, String oldPassword, String newPassword);
	
	/**
	 * Retrieve user object.
	 * Useful to show user profiles.
	 * @param id
	 * @return
	 */

	public User getUser(Long id);
	
	/**
	 * Requires the user object.
	 * Update the user data with merge functionality at Datalayer.
	 * @param user
	 * @return
	 */

	public boolean updateUser(User user);
	
	/**
	 * Requires user id to remove user object completely from database.
	 * @param id
	 * @return
	 */
	public boolean deleteUser(Long id);
	
	/**
	 * This closes the Entity manager class and clear current user transactions.
	 * @return
	 */
	public boolean logout();

}
