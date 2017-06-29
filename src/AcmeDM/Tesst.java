package AcmeDM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import AcmePD.Reg;



public class Tesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reg r=new Reg();
		r.setUser_id(2);
		r.setUsername("sandrasmith");
		r.setAnswer("micky");
		r.setFirstname("sandra");
		r.setLastname("Smith");
		r.setPassword("mario123");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
	}

}
