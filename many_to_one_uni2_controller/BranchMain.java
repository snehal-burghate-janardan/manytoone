package many_to_one_uni2_controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_one_uni2_dao.BankDao;
import many_to_one_uni2_dao.BranchDao;
import many_to_one_uni2_dto.Bank;
import many_to_one_uni2_dto.Branch;

public class BranchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  Scanner sc=new Scanner(System.in);
	  BranchDao dao=new  BranchDao();
	  BankDao bankdao=new BankDao();
	  boolean flag=true;
	   do {
		  System.out.println("\n 1.add bank \n 2.for add branch \n 3.for update bank \n 4.for update branch \n 5.for get details of bank \n 6. for get details of brnch \n 7.for all details bank \n 8.for all details of branch \n 9.for delete bank \n 10.for delete brnch");
	      System.out.println("Enter your choice");
	      int choice=sc.nextInt();
	      
	      switch (choice) {
		case 1:{
			System.out.println("Enter the bank name");
			String name=sc.next();
			System.out.println("Enter the headoffice");
			String headOffice=sc.next();
			System.out.println("Enter the ceo name");
			String ceoname=sc.next();
			
			Bank bank=new Bank();
			
			bank.setName(name);
			bank.setHeadoffice(headOffice);
			bank.setCeo(ceoname);
			
			bankdao.saveBank(bank);
		}
		break;
		case 2:{
			System.out.println("Enter the id");
			int bid=sc.nextInt();
			System.out.println("Enter the ifsc code");
			String ifsc=sc.next();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the address");
			String add=sc.next();
			System.out.println("Enter the number");
			long phone=sc.nextLong();
			
			Branch branch=new Branch();
			branch.setIfsc(ifsc);
			branch.setName(name);
			branch.setAddress(add);
			branch.setPhone(phone);
			
			dao.saveBranch(bid, branch);
		}
		break;
		case 3:{
			System.out.println("Enter the id for update");
			int id=sc.nextInt();
			System.out.println("Enter the bank name");
			String name=sc.next();
			System.out.println("Enter the headoffice");
			String headOffice=sc.next();
			System.out.println("Enter the ceo name");
			String ceoname=sc.next();
			
			Bank bank=new Bank();
			bank.setId(id);
			bank.setName(name);
			bank.setHeadoffice(headOffice);
			bank.setCeo(ceoname);

			
			bankdao.updateBank(id, bank);
		}
		break;
		case 4:{
			System.out.println("Enter the id");
			int bid=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			
			Branch branch=new Branch();
			branch.setBid(bid);
			branch.setName(name);
			
			dao.updateBrnach(bid, name);
		}
		break;
		case 5:{
			System.out.println("Enter the bank id");
			int id=sc.nextInt();
			Bank bank=new Bank();
			bank.setId(id);
			
			bankdao.getBank(id);
		}
		break;
		case 6:{
			System.out.println("Enter the branch id ");
			int bid=sc.nextInt();
			
			Branch branch=new Branch();
			branch.setBid(bid);
			
			dao.getBranch(bid);
		}
		break;
		case 7:{
			bankdao.getAllBank();
			
		}
		break;
		case 8:{
			dao.getAllBranch();
		}
		break;
		case 9:{
			System.out.println("Enter the id for delete");
			int id=sc.nextInt();
			bankdao.deleteBank(id);
		}
		break;
		case 10:{
			System.out.println("Enter the bid for delete");
			int bid=sc.nextInt();
			dao.deleteBarnch(bid);
			
		}
		break;
		default:System.out.println("thank you");
			break;
		}
	  }
	  while(flag);
	  
	}

}
