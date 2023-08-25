package com.softmelon.engineering.Sofy_ACO.service.readOnly;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;
import com.softmelon.engineering.Sofy_ACO.exceptions.ResourceNotFoundException;
import com.softmelon.engineering.Sofy_ACO.repository.GenericRepository;

/**
 * This abstract service class provides read-only operations for entities and
 * their responses.
 *
 * @param <Entity>   The type of the entity that implements the IModel
 *                   interface.
 * @param <Response> The type of the response that implements the IResponse
 *                   interface.
 */
@Service
public abstract class GenericReadOnlyService<Entity extends IModel> implements IReadOnlyService<Entity> {

	@Autowired
	protected GenericRepository<Entity> repository;

	/**
	 * Retrieves a list of all entities.
	 *
	 * @return A list containing all available entities.
	 */
	@Override
	public List<Entity> findAll() {
		return repository.findAll();
	}

	/**
	 * Retrieves an entity by its unique identifier.
	 *
	 * @param id The unique identifier of the entity.
	 * @return The entity corresponding to the provided ID.
	 * @throws ResourceNotFoundException If the entity with the provided ID is not
	 *                                   found.
	 */
	@Override
	public Entity read(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NON TROVATO"));
	}
}