package com.eos.enitity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "pro_discrp")
public class ProjectDescriptionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private  Long projectId;
	
	@Column(name = "pro_title")
	private  String projectTitle;
	
	@Column(name = "pro_start_date")
	private  Date  projectStartDate;
	
	@Column(name = "pro_start_end")
	private  Date  projectCompletionDate;
	
	@Column(name = "priority_level")
	private  String priorityLevel;
	
	@Column(name = "cost")
	private  Double projectCost;
	
	@Column(name = "main_cost")
	private  Double projectMaintanceCost;
	
	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private RequestUserEntity requestUser;
	
	

}
