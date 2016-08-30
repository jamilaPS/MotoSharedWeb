package com.tads.motoshared.util;

import com.tads.motoshared.dao.GenericDAO;
import com.tads.motoshared.model.Motorcycle;
import com.tads.motoshared.model.User;

public class Teste {

	public static void main(String[] args) {
		GenericDAO dao = new GenericDAO();
		User user = new User();
		user.setEmail("email");
		user.setPassword("pass");
		user.setUsername("name");
		user.setId(1L);
//		dao.inserir(user);
		
		Motorcycle moto = new Motorcycle();
		moto.setBrand("harley davidson");
		moto.setModel("fat boy");
		moto.setOwner(user);
		moto.setPhone("99707070");
		moto.setPrice(30000.0);
		moto.setYear(2010);
		dao.inserir(moto);
	}

}
