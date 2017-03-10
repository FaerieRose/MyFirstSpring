package nl.programit.spring_test.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Novel extends Book {
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> tableOfContents = new ArrayList<String>();
	
	@OneToOne(fetch=FetchType.EAGER)
	private Page frontPage;

	@OneToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Page> pages = new ArrayList<Page>();
	
	public List<String> getTableOfContents() {
		return tableOfContents;
	}
	public void setTableOfContents(List<String> tableOfContents) {
		this.tableOfContents = tableOfContents;
	}
	
	public Page getFrontPage() {
		return frontPage;
	}
	public void setFrontPage(Page frontPage) {
		this.frontPage = frontPage;
	}
	
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public void addPage(Page page) {
		this.pages.add(page);
	}
	public void removePage(Page page) {
		this.pages.remove(page);
	}
	
}
