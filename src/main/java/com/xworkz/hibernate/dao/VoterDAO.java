package com.xworkz.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xworkz.hibernate.dto.VoterDTO;

import src.xworkz.hibernate.util.HibernateUtil;

public class VoterDAO {

	private Session session;

	public void insertVoter(VoterDTO voterDto) {
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(voterDto);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public List retrieveAllVoter() {
		Session session = HibernateUtil.getFactory().openSession();
		List voter = session.createQuery("from VoterDTO").list();
		
		return voter;
	}
	
	public void deleteVoter(String voterId) {
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		VoterDTO voter = retrieveVoterById(voterId);
		try {
			System.out.println(voter.toString());
			session.delete(voter);
			tx.commit();
			System.out.println("Voter was deleted with id " +voterId);
		} catch(HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		
	}
	
	public VoterDTO retrieveVoterById(String voterId) {
		Session session = HibernateUtil.getFactory().openSession();
		VoterDTO dto =(VoterDTO) session.get(VoterDTO.class, voterId);
		System.out.println("Retrieved voter with id " +dto.toString());
		//session.close();
		return dto;
	}
	
	public void updateVoter(String voterId) {
		
		Session session = HibernateUtil.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		VoterDTO dto = (VoterDTO) session.get(VoterDTO.class, voterId);
		dto.setAddr("Gm Palya Bangalore");
		tx.commit();
	}
}
