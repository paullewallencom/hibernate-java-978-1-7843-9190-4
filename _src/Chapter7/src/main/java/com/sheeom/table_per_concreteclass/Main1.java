package com.sheeom.table_per_concreteclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Aarush");
		session.save(employee);

		PermanentEmployee permanentEmployee = new PermanentEmployee();
		permanentEmployee.setId(2);
		permanentEmployee.setName("Mike");
		permanentEmployee.setSalary(10000D);
		session.save(permanentEmployee);

		ContractualEmployee contractualEmployee = new ContractualEmployee();
		contractualEmployee.setId(3);
		contractualEmployee.setName("Vishal");
		contractualEmployee.setHourlyRate(200D);
		contractualEmployee.setContractPeriod(100F);
		session.save(contractualEmployee);

		transaction.commit();

		session.close();


		HibernateUtil.shutdown();
	}
}
