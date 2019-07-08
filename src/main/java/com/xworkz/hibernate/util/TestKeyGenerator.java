package com.xworkz.hibernate.util;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TestKeyGenerator implements IdentifierGenerator {

	static int count = 1001;// will get memory only once and retain its value

	Serializable Counter2() {
		// count++;//incrementing the value of static variable
		// System.out.println(count);
		return "SEQ" +count++;
	}

	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		return Counter2();
	}

	
}
