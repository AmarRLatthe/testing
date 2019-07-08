package com.xworkz.hibernate;

import java.util.Iterator;
import java.util.List;

import com.xworkz.hibernate.dao.VoterDAO;
import com.xworkz.hibernate.dto.VoterDTO;

import src.xworkz.hibernate.util.HibernateUtil;


public class Tester {

	public static void main(String[] args) {
		
		VoterDAO dao = new VoterDAO();
		
		VoterDTO dto = new VoterDTO();
		dto.setVoterName("Hemraj Kota");
		dto.setAge(27);
		dto.setGender("Male");
		dto.setAddr("Kalamandir Marathali, Bangalore");
		//dao.insertVoter(dto);
		
		
		List voter = dao.retrieveAllVoter();
		for (Iterator iterator = voter.iterator(); iterator.hasNext();){
			VoterDTO voter1 =(VoterDTO) iterator.next(); 
			
			System.out.println(voter1.toString());
		}
		
//		dao.deleteVoter("3732f511-15c5-448c-9f65-9b898d65b099");
		//dao.updateVoter("402881846789adfb016789adfdd40000");
		//List voter = dao.retrieveAllVoter();
		HibernateUtil.closeFactory();
	}
	
}
