package com.eos.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eos.custom.exception.InvalidRoleException;
import com.eos.custom.exception.ResourceNotFoundException;
import com.eos.dto.RequestUserDto;
import com.eos.enitity.ProjectDescriptionEntity;
import com.eos.enitity.RequestUserEntity;
import com.eos.mapper.RequestUserMapper;
import com.eos.repository.ProjectDiscreptionRepository;
import com.eos.repository.RequestUserRepository;
import com.eos.service.RequestUserService;

@Service
public class RequestUserServiceImpl  implements RequestUserService{

	@Autowired
	RequestUserRepository requestUserRepository;
	
	@Autowired 
	ProjectDiscreptionRepository projectDiscreptionRepository;
	
	@Override
	public RequestUserDto createRequest(RequestUserDto requestUserDto) {
		RequestUserEntity requestUserEntity = RequestUserMapper.mapToRequestUserEntity(requestUserDto);
		RequestUserEntity saveRequestUserEntity = requestUserRepository.save(requestUserEntity);
		return RequestUserMapper.mapToRequestUserDto(saveRequestUserEntity);
	}

	@Override
	public List<RequestUserDto> getAllReqSubmitted() {

		List<RequestUserEntity> request = requestUserRepository.findAll();
		if(request.isEmpty()) {
			throw new ResourceNotFoundException("No Request in table");
		}
		return request.stream()
				      .sorted((id1,id2) -> Long.compare(id2.getId(), id1.getId()))
				      .map(RequestUserMapper::mapToRequestUserDto)
				      .collect(Collectors.toList());
		
	}


	@Override
	public RequestUserDto updateUserRequestStatus(Long requestId, String role) {
		RequestUserEntity request =  requestUserRepository.findById(requestId).orElseThrow(() -> new
				ResourceNotFoundException("Request id is not present in databases" + requestId));
		if(role != null && role.equals("ADMIN")) {
		   request.setStatusLevelOne(true);	
		}else if (role != null && role.equals("BOSS")) {
			request.setStatusLevelTwo(true);
		}else {
			throw new InvalidRoleException("Role is Not Valid Or Not Present" +role);
		}
		RequestUserEntity update = requestUserRepository.save(request);
		return RequestUserMapper.mapToRequestUserDto(update);
	}

	@Override
	public RequestUserDto projectDetailsUpdate(Long id, ProjectDescriptionEntity projectDescriptionEntity) {
		RequestUserEntity request = requestUserRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Emp is not present"));
		request.setStatusLevelTwo(true);
		requestUserRepository.save(request);
		projectDescriptionEntity.setRequestUserEntity(request);
		projectDiscreptionRepository.save(projectDescriptionEntity);
		return null;
	}

}
