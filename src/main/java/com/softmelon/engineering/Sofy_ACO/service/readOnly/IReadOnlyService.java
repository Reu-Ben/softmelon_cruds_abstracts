package com.softmelon.engineering.Sofy_ACO.service.readOnly;

import java.util.List;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;

/**
 * This interface defines read-only operations for working with entities and
 * their responses.
 *
 * @param <Entity>   The type of the entity that implements the IModel
 *                   interface.
 * @param <Response> The type of the response that implements the IResponse
 *                   interface.
 */
public interface IReadOnlyService<Entity extends IModel> {

	/**
	 * Retrieves an entity by its unique identifier.
	 *
	 * @param id The unique identifier of the entity.
	 * @return The entity corresponding to the provided ID, or null if not found.
	 */
	Entity read(Long id);

	/**
	 * Retrieves a list of all entities.
	 *
	 * @return A list containing all available entities.
	 */
	List<Entity> findAll();
}
