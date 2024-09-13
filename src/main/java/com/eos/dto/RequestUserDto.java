package com.eos.dto;

import java.sql.Date;

import com.eos.enitity.ProjectDescriptionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
      
	  private Long Id;
	  private String title;
	  private Date reqDate;
	  private Long empId;
	  private String discreption;
	  private String type;
      private boolean statusLevelOne;
	  private boolean statusLevelTwo;
	  private ProjectDescriptionEntity project;
}
