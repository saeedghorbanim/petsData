package com.saeed.petsData.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pets")
public class Pet {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   @NotNull
	   @Size(min = 5, max = 30, message=" must be between 5 and 30 dude")
	   private String name;
	   
	   @NotNull
	   @Min(value = 1)
	   private Integer age;
	   
	   private String description;
	   
	   @Column(updatable=false)
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date createdAt;
	    
	   @DateTimeFormat(pattern="yyyy-MM-dd")
	   private Date updatedAt;
	   
	   //telling java to automatically generate time stamps for create at and update at
	   @PrePersist
	   protected void onCreate(){
	       this.createdAt = new Date();
	   }
	   @PreUpdate
	   protected void onUpdate(){
	       this.updatedAt = new Date();
	   }
	   
	   
	   public Pet() {
		   
	   }
	   
	   public Pet(String name, Integer age, String description ) {
		   this.name = name;
		   this.age = age;
		   this.description = description;
		   
	   }
	   
	   //Generate GETTERS and SETTERS
	   public Long getId() {
		    return id;
	   }

	   public void setId(Long id) {
		    this.id = id;
	   }

	   public String getName() {
		    return name;
	   }

	   public void setName(String name) {
		    this.name = name;
	   }

	   public Integer getAge() {
		    return age;
	   }

	   public void setAge(Integer age) {
		    this.age = age;
	   }

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	    
	   
}

