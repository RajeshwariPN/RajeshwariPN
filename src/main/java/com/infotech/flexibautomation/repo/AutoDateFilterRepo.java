package com.infotech.flexibautomation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.infotech.flexibautomation.entity.AvokaResults;

public interface AutoDateFilterRepo extends JpaRepository<AvokaResults, Integer> , JpaSpecificationExecutor<AvokaResults> {

}
