package com.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VIEW1")
public class View extends baseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long views;
	
	@ManyToOne()
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
}
