package com.softmelon.engineering.Sofy_ACO.service.persist;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;

/**
 * 
 * @author Engineer-Mensah
 *
 * @param <Entity>
 */

public interface IPersistService<Entity extends IModel> {

	/**
	 * Creates an entity.
	 *
	 * @param entity The entity to create.
	 * @return The created entity or a status indicator.
	 * @throws PersistenceException if the creation process fails.
	 */
	public Entity create(Entity entity) throws PersistenceException;

	/**
	 * Updates an entity.
	 *
	 * @param entity The entity to update.
	 * @return The updated entity or a status indicator.
	 * @throws EntityNotFoundException if the entity doesn't exist.
	 * @throws PersistenceException    if the update process fails.
	 */
	public Entity update(Entity entity) throws EntityNotFoundException, PersistenceException;

	/**
	 * Deletes an entity by its unique identifier.
	 *
	 * @param id The unique identifier of the entity to delete.
	 * @throws EntityNotFoundException if the entity doesn't exist.
	 * @throws PersistenceException    if the delete process fails.
	 */
	public void delete(Long id) throws EntityNotFoundException, PersistenceException;

}
