package com.davidfischer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Zutat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	//Wasser = 0 , Sirup = 1, Saft = 2;
	private int parameter;
	
	private double menge;
	
    @ManyToMany( mappedBy = "zutaten", fetch = FetchType.LAZY)
    //@JoinColumn(name = "cocktail_id")
    private Set<Cocktail> cocktail = new HashSet<Cocktail>();
    
    
    public Zutat(String name){
    	this.name = name;
    }
    public Zutat(){
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParameter() {
		return parameter;
	}

	public void setParameter(int parameter) {
		this.parameter = parameter;
	}
	


	public double getMenge() {
		return menge;
	}

	public void setMenge(double menge) {
		this.menge = menge;
	}
	public Set<Cocktail> getCocktail() {
		return cocktail;
	}
	public void setCocktail(Set<Cocktail> cocktail) {
		this.cocktail = cocktail;
	}



}
