package com.eos.controller;

import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eos.custom.exception.InvalidRoleException;
import com.eos.custom.exception.ResourceNotFoundException;
import com.eos.dto.RequestUserDto;
import com.eos.enitity.ProjectDescriptionEntity;
import com.eos.enitity.RequestUserEntity;
import com.eos.service.RequestUserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/User")
public class RequestUserController {

	RequestUserService requestUserService;

	public RequestUserController(RequestUserService requestUserService) {
		super();
		this.requestUserService = requestUserService;
	}

	@PostMapping("/formRequest")
	public ResponseEntity<RequestUserDto> requestUser(@RequestBody() RequestUserDto requestUserDto) {

		try {
			if (requestUserDto == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			RequestUserDto saveRequestUserDto = requestUserService.createRequest(requestUserDto);
			return new ResponseEntity<>(saveRequestUserDto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getAllRequest")
	public ResponseEntity<List<RequestUserDto>> getAllRequest() {
		List<RequestUserDto> getAllReqSubmit = requestUserService.getAllReqSubmitted();
		return ResponseEntity.ok(getAllReqSubmit);

	}

	@PutMapping("approve/{id}/{role}")
	public ResponseEntity<RequestUserDto> requestStatusUpdate(@PathVariable("role") String role,
			@PathVariable("id") Long requestId) {
		try {
			RequestUserDto requestUser = requestUserService.updateUserRequestStatus(requestId, role);
			return ResponseEntity.ok(requestUser);
		} catch (InvalidRoleException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@PostMapping("/projectDetailsUpdate/{id}")
	public ResponseEntity<RequestUserDto> projectDetailsUpdate(
			@RequestBody ProjectDescriptionEntity projectDescriptionEntity, @PathVariable("id") Long id) {
		try {
			if (projectDescriptionEntity == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			requestUserService.projectDetailsUpdate(id, projectDescriptionEntity);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
