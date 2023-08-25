package com.softmelon.engineering.Sofy_ACO.service.persist;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Service;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;
import com.softmelon.engineering.Sofy_ACO.exceptions.ResourceNotFoundException;
import com.softmelon.engineering.Sofy_ACO.repository.GenericRepository;

@Service
public class GenericPersistService<Entity extends IModel> implements IPersistService<Entity> {

	private GenericRepository<Entity> repository;

	@Override
	public Entity create(Entity entity) throws PersistenceException {
		return repository.save(entity);
	}

	@Override
	public Entity update(Entity entity) throws EntityNotFoundException, PersistenceException {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) throws EntityNotFoundException, PersistenceException {
		// TODO Auto-generated method stub
		Entity resource = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND"));
		repository.delete(resource);
	}
}