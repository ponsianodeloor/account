package com.sofka.account.model;

import java.io.Serializable;

/**
 * The persistent class for the parameter database table.
 * 
 * @author Ponsiano De Loor
 * @version 1.0 - 04/03/2024
 */
public class Parameter extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String code;

	private String value;

	private String description;

	public Parameter() {
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}