package com.tads.motoshared.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jamila on 13/08/16.
 */
@Entity
public class User implements Serializable
{
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
    private String username;
    private String password;
    private String email;

    public User()
    {

    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
    
    
}
