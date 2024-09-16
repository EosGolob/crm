package com.eos.enitity;

import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "req_Entity")
@JsonIgnoreProperties({"project"})
public class RequestUserEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long Id;
	  
	  @Column(name = "title")
	  private String title;
	  
	  @Column(name = "req_Date")
	  private Date reqDate;
	  
	  @Column(name ="emp_id")
	  private Long empId;
	  
	  @Column(name ="discrp")
	  private String description;
	  
	  @Column(name = "type")
	  private String type;
	  
	  @Column(name = "statLevOne")
	  private boolean statusLevelOne;
	  
	  @Column(name = "statLevTwo")
	  private boolean statusLevelTwo;
	  
	  @OneToOne( mappedBy = "requestUserEntity" ,cascade = CascadeType.ALL)
	  @JsonManagedReference
	  private ProjectDescriptionEntity project;
}
