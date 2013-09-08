package com.datapine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@NamedQueries({
	@NamedQuery(
	name = "findByEmailAndPassword",
	query = "from User u where u.email = :email AND u.password = :password"
	),
	@NamedQuery(
			name = "findAllUser",
			query = "from User u Order By u.id ASC"
	),
	@NamedQuery(
			name = "findById",
			query = "from User u where u.id = :id"
			)
})

/**
 * An entity class which contains the information of a single User.
 * This entity class support constructor as well as setter Injection.
 * Just to show different way of injection.
 * @author Mohd Nadeem Akhtar
 */
@Entity
@Table(name="User")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String gender;

	/**
	 * Default Constructor 
	 */
	public User(){
		
	}
	
	/**
	 * Constructor used for Injection 
	 * @param email
	 */
	@Autowired
	public User(final String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
