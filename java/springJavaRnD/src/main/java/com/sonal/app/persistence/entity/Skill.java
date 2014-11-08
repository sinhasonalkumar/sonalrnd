package com.sonal.app.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "skillid")
	private Long skillId;
	
	@Column(name = "skillname")
	private String skillName;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "employee_skill" , joinColumns = {@JoinColumn(name="skill_id")} , inverseJoinColumns = {@JoinColumn(name="employee_id")})
	private Set<Employee> employees;

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	


}
