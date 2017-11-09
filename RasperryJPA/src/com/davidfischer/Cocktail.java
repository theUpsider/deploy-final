package com.davidfischer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cocktail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToMany(cascade = { 
		    CascadeType.PERSIST, 
		    CascadeType.MERGE
		})
	//@JoinColumn(name = "zutat_id")
	 @JoinTable(name = "cocktail_zutat",
     joinColumns = @JoinColumn(name = "cocktail_id"),
     inverseJoinColumns = @JoinColumn(name = "zutat_id"))
	Set<Zutat> zutaten = new HashSet<Zutat>();
	
	public Cocktail(String name) {
		this.name = name;
	}
	public Cocktail() {
	}
	
    public void addZutat(Zutat zutat) {
        zutaten.add(zutat);
        zutat.getCocktail().add(this);
    }
    public void removeZutat(Zutat zutat) {
        zutaten.remove(zutat);
        zutat.getCocktail().remove(this);
    }
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
