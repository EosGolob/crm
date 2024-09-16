package com.eos.service;

import java.util.List;

import com.eos.dto.RequestUserDto;
import com.eos.enitity.ProjectDescriptionEntity;
import com.eos.enitity.RequestUserEntity;

public interface RequestUserService {

	RequestUserDto createRequest(RequestUserDto requestUserDto);

	List<RequestUserDto> getAllReqSubmitted();

	RequestUserDto updateUserRequestStatus(Long requestId, String role);

	RequestUserDto projectDetailsUpdate(Long id, ProjectDescriptionEntity projectDescriptionEntity);

}
