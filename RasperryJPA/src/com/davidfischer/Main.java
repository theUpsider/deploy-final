package com.davidfischer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class Main {
	
	private float alkoholstaerke = 100; //normal
	private float menge;
	
	    
	 public static void main( String[] args )
	  {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RasperryJPA");
	    EntityManager em = emf.createEntityManager();
	    try
	    {
	    	Cocktail cocktail1 = new Cocktail("GinTonic");
	    	Cocktail cocktail2 = new Cocktail("TonicGin");
	    	
	    	Zutat zutat1 = new Zutat("Gin");
	    	zutat1.setMenge((double)20);
	    	zutat1.setParameter(1);
	    	
	    	Zutat zutat2 = new Zutat("Tonic");
	    	zutat2.setMenge((double)50);
	    	zutat2.setParameter(1);
	    
	    	cocktail1.addZutat(zutat1);
	    	cocktail1.addZutat(zutat2);
	    	
	    	cocktail2.addZutat(zutat2);
	    	cocktail2.addZutat(zutat1);
	    	
	    	em.getTransaction().begin();
	    	//cperisten
	    	em.persist(cocktail1);
	    	em.persist(cocktail2);
	    	em.getTransaction().commit();
	    	
		      em.close();
		      emf.close();
	    }
	    catch ( Exception e )
	    {
	      e.printStackTrace();
	      em.getTransaction().rollback();
	    }
	   // System.exit(0);
	  }

}
