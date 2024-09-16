package com.eos.mapper;

import java.util.List;

import com.eos.dto.RequestUserDto;
import com.eos.enitity.RequestUserEntity;

public class RequestUserMapper {

	public static RequestUserDto mapToRequestUserDto(RequestUserEntity requestUserEntity) {
			
	
//		return new RequestUserDto(requestUserEntity.getId(), requestUserEntity.getTitle(),
//				requestUserEntity.getReqDate(), requestUserEntity.getEmpId(), requestUserEntity.getDescription(),
//				requestUserEntity.getType(), requestUserEntity.isStatusLevelOne(), requestUserEntity.isStatusLevelTwo()
//
//		);
		   if (requestUserEntity == null) {
	            return null;
	        }

	        RequestUserDto requestUserDto = new RequestUserDto();
	        requestUserDto.setId(requestUserEntity.getId());
	        requestUserDto.setTitle(requestUserEntity.getTitle());
	        requestUserDto.setReqDate(requestUserEntity.getReqDate());
	        requestUserDto.setEmpId(requestUserEntity.getEmpId());
	        requestUserDto.setDiscreption(requestUserEntity.getDescription()); // Correcting the typo
	        requestUserDto.setType(requestUserEntity.getType());
	        requestUserDto.setStatusLevelOne(requestUserEntity.isStatusLevelOne());
	        requestUserDto.setStatusLevelTwo(requestUserEntity.isStatusLevelTwo());
//	        requestUserDto.setProject(requestUserEntity.getProject()); 

	        return requestUserDto;
	    }


	public static RequestUserEntity mapToRequestUserEntity(RequestUserDto requestUserDto) {
//		return new RequestUserEntity(requestUserDto.getId(), requestUserDto.getTitle(), requestUserDto.getReqDate(),
//				requestUserDto.getEmpId(), requestUserDto.getDiscreption(), requestUserDto.getType(),
//				requestUserDto.isStatusLevelOne(), requestUserDto.isStatusLevelTwo());
//	}
		 if (requestUserDto == null) {
	            return null;
	        }

	        RequestUserEntity requestUserEntity = new RequestUserEntity();
	        requestUserEntity.setId(requestUserDto.getId());
	        requestUserEntity.setTitle(requestUserDto.getTitle());
	        requestUserEntity.setReqDate(requestUserDto.getReqDate());
	        requestUserEntity.setEmpId(requestUserDto.getEmpId());
	        requestUserEntity.setDescription(requestUserDto.getDiscreption()); // Correcting the typo
	        requestUserEntity.setType(requestUserDto.getType());
	        requestUserEntity.setStatusLevelOne(requestUserDto.isStatusLevelOne());
	        requestUserEntity.setStatusLevelTwo(requestUserDto.isStatusLevelTwo());
//	        requestUserEntity.setProject(requestUserDto.getProject());

	        return requestUserEntity;
	}
}
