package many_to_one_uni2_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni2_dto.Bank;
import many_to_one_uni2_dto.Branch;



public class BranchDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	
	}
	public void saveBranch(int id,Branch branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=entityManager.find(Bank.class,id);
		if(bank!=null) {
			
		branch.setBank(bank);
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		}
	}
	public void updateBrnach(int id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class,id);
		branch.setName(name);
		if(branch!=null) {
		branch.setBid(id);
		branch.setBank(branch.getBank());
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		}
	}
	public void deleteBarnch(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class,id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			
			entityTransaction.commit();
		}
	}
	public Branch getBranch(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class,id);
		return branch;
	}
	
	public List<Bank> getAllBranch(){ 
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select b from Bank b");
		List<Bank>list=query.getResultList();
		return list;
		
	}
}


