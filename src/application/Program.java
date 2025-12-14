package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
	
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById \t\n");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment \t\n");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll\n");
		list = sellerDao.findAll();
		for (Seller obj:list) {
			System.out.println(obj);
		
		}
/*		System.out.println("\n=== Test 4: seller Insert \t\n");	
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department );
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
*/
		Scanner sc= new Scanner(System.in); 
		
		System.out.println("\n=== Test 5: seller Update \n");
		seller = sellerDao.findById(36);
		seller.setName("Martha Waine");
		seller.setBaseSalary(100.0);
		sellerDao.update(seller);
		System.out.println("Done! Update completed");
		
		System.out.println("\n=== Test 6: seller deleteById \n");
		System.out.print("\nEnter id for delete test: \n");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
			
/*		for (Seller obj:list) {
		System.out.println(obj);
		}
*/	}
}

