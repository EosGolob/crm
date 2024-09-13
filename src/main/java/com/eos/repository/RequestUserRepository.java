package com.eos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eos.enitity.RequestUserEntity;

public interface RequestUserRepository extends JpaRepository<RequestUserEntity, Long> {

}
