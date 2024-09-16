package com.eos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eos.enitity.RequestUserEntity;

public interface RequestUserRepository extends JpaRepository<RequestUserEntity, Long> {



}
