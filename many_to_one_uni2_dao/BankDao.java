package many_to_one_uni2_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni2_dto.Bank;

public class BankDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	
	}
	public void saveBank(Bank bank) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
		
		}
	public void updateBank(int id,Bank bank) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank1=entityManager.find(Bank.class,id);
		if(bank1!=null) {
			bank.setId(id);
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
	}
		else
			System.out.println("bank not exist");
	}
	public void deleteBank(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=entityManager.find(Bank.class,id);
		if(bank!=null) {
			entityTransaction.begin();
			entityManager.remove(bank);
			
			entityTransaction.commit();
		}
	}
	public void getBank(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=entityManager.find(Bank.class,id);
		if(bank!=null)
		System.out.println(bank);
	}
	
	public List<Bank> getAllBank(){ 
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select s from Bank s");
		List<Bank>list=query.getResultList();
		return list;
		
	}
}

