package nl.programit.spring_test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Page {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int nr;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	
	/**
	 * This method overrides the standard equals method to allow 
	 *   two objects to be equal when the class and id are
	 *   identical
	 *   @param obj the object to be compared for equality to this
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			Page other = (Page) obj;
			if (this.id == other.id) return true;
		}
		return false;
	}		
}
