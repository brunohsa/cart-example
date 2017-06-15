package br.com.cart.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.cart.enums.ActionType;
import br.com.cart.enums.Entity;

@javax.persistence.Entity(name = "LOG")
public class Log {

	public Log() {

	}

	public Log(ActionType action, Entity entity, Long referenceId, String description, Calendar date) {
		this.action = action;
		this.entity = entity;
		this.referenceId = referenceId;
		this.description = description;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ACTION")
	@Enumerated(EnumType.STRING)
	private ActionType action;

	@Column(name = "ENTITY")
	@Enumerated(EnumType.STRING)
	private Entity entity;

	@Column(name = "REFERENCE_ID")
	private Long referenceId;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DATE")
	private Calendar date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
}
