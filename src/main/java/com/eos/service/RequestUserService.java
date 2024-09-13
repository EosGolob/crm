package com.eos.service;

import java.util.List;

import com.eos.dto.RequestUserDto;

public interface RequestUserService {

	 RequestUserDto createRequest(RequestUserDto requestUserDto);
	 List<RequestUserDto> getAllReqSubmitted();
	 RequestUserDto updateUserRequestStatus(Long requestId, String role);


	
}
