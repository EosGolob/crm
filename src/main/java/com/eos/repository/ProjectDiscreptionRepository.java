package com.eos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eos.enitity.ProjectDescriptionEntity;

@Repository
public interface ProjectDiscreptionRepository extends JpaRepository<ProjectDescriptionEntity, Long>  {

}
