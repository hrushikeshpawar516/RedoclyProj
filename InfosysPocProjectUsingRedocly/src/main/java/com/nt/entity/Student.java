package com.nt.entity;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="Student")
public class Student implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sRollNo;
	
	@Nonnull
	@Column(length = 200)
	private String sName;
	
	@Nonnull
	private Integer sAge;

	@Column(length = 200)
	@Nonnull
	private String sEmail;
	 
	 @Nonnull
	 private Long sPhoneno;

}
