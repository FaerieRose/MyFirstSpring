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
	
	
}
