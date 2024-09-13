package com.eos.mapper;

import com.eos.dto.RequestUserDto;
import com.eos.enitity.RequestUserEntity;

public class RequestUserMapper {
	
	public static RequestUserDto mapToRequestUserEntity(RequestUserEntity requestUserEntity) {
		return new RequestUserDto(
				requestUserEntity.getId(),
				requestUserEntity.getTitle(),
				requestUserEntity.getReqDate(),
				requestUserEntity.getEmpId(),
				requestUserEntity.getDiscreption(),
				requestUserEntity.getType(),
				requestUserEntity.isStatusLevelOne(),
				requestUserEntity.isStatusLevelTwo(),
				requestUserEntity.getProject());
					
				
	}

	public static RequestUserEntity mapToRequestUserDto(RequestUserDto requestUserDto) {
		return new RequestUserEntity(
					requestUserDto.getId(),
					requestUserDto.getTitle(),
					requestUserDto.getReqDate(),
					requestUserDto.getEmpId(),
					requestUserDto.getDiscreption(),
					requestUserDto.getType(),
					requestUserDto.isStatusLevelOne(),
					requestUserDto.isStatusLevelTwo(),
					requestUserDto.getProject()
				);
	}

}
