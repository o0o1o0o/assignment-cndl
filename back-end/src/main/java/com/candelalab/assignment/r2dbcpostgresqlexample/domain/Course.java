package com.candelalab.assignment.r2dbcpostgresqlexample.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Course.
 */
@Table("course")
//@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Course {

  public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

/**
   * Instantiates a new course.
   *
   * @param id the id
   * @param title the title
   * @param slug the slug
   * @param author_id the author id
   * @param category the category
   */
  public Course(Integer id, String title, String slug, String author_id, String category) {
		super();
		this.id = id;
		this.title = title;
		this.slug = slug;
		this.author_id = author_id;
		this.category = category;
	}

/** The id. */
@Id
  private Integer id;
  
  /** The title. */
  private String title;
  
  /** The slug. */
  private String slug;
  
  /** The author id. */
  private String author_id;
  
  /** The category. */
  private String category;

public Object getTitle() {
	// TODO Auto-generated method stub
	return title;
}
}
