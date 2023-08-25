package com.softmelon.engineering.Sofy_ACO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;

@NoRepositoryBean
public interface GenericRepository<Entity extends IModel> extends JpaRepository<Entity, Long> {

}
