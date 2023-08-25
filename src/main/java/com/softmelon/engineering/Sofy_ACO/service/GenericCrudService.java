package com.softmelon.engineering.Sofy_ACO.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;
import com.softmelon.engineering.Sofy_ACO.repository.GenericRepository;
import com.softmelon.engineering.Sofy_ACO.request.abstracts.BaseAbstractRequest;
import com.softmelon.engineering.Sofy_ACO.service.helper.IHelper;
import com.softmelon.engineering.Sofy_ACO.service.persist.GenericPersistService;
import com.softmelon.engineering.Sofy_ACO.service.readOnly.GenericReadOnlyService;

/**
 * This class provides generic CRUD (Create, Read, Update, Delete) operations
 * for entities using a repository and helper functions. It interacts with
 * read-only and persistent services to perform these operations on the
 * specified entity type.
 *
 * @param <Entity>   The type of the entity that implements the IModel
 *                   interface.
 * @param <Request>  The type of the request that extends BaseAbstractRequest.
 * @param <Response> The type of the response that implements the IResponse
 *                   interface.
 */
public class GenericCrudService<Entity extends IModel, Request extends BaseAbstractRequest> {

	@Autowired
	protected GenericRepository<Entity> repository;

	@Autowired
	protected IHelper<Entity, Request> helper;

	@Autowired
	protected GenericReadOnlyService<Entity> readOnlyService;

	@Autowired
	protected GenericPersistService<Entity> persistantService;

	/**
	 * Retrieves a list of all entities.
	 *
	 * @return A list containing all available entities.
	 */
	public List<Entity> findAll() {
		return readOnlyService.findAll();
	}

	/**
	 * Retrieves an entity by its unique identifier.
	 *
	 * @param id The unique identifier of the entity.
	 * @return The entity corresponding to the provided ID, or null if not found.
	 */
	public Entity read(Long id) {
		return readOnlyService.read(id);
	}

	/**
	 * Creates an entity.
	 *
	 * @param entity The entity to be created.
	 * @return The created entity.
	 * @throws PersistenceException If there is an issue with persistence.
	 */
	public Entity create(Entity entity) throws PersistenceException {
		return persistantService.create(entity);
	}

	/**
	 * Updates an entity.
	 *
	 * @param entity The entity to be updated.
	 * @return The updated entity.
	 * @throws EntityNotFoundException If the entity to be updated is not found.
	 * @throws PersistenceException    If there is an issue with persistence.
	 */
	public Entity update(Entity entity) throws EntityNotFoundException, PersistenceException {
		return persistantService.update(entity);
	}

	/**
	 * Deletes an entity by its unique identifier.
	 *
	 * @param id The unique identifier of the entity to be deleted.
	 * @throws EntityNotFoundException If the entity to be deleted is not found.
	 * @throws PersistenceException    If there is an issue with persistence.
	 */
	public void delete(Long id) throws EntityNotFoundException, PersistenceException {
		persistantService.delete(id);
	}
}