package com.softmelon.engineering.Sofy_ACO.service.helper;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;
import com.softmelon.engineering.Sofy_ACO.response.abstracts.IResponse;

/**
 * This functional interface defines a contract for building response objects
 * from entity objects. It is used to convert entity instances into response
 * instances according to specific business logic or requirements.
 *
 * @param <Entity>   The type of the entity that implements the IModel
 *                   interface.
 * @param <Response> The type of the response that implements the IResponse
 *                   interface.
 */
@FunctionalInterface
public interface IResponseBuilder<Entity extends IModel, Response extends IResponse> {

	/**
	 * Builds a response object from the provided entity object.
	 *
	 * @param entity The entity from which to build the response.
	 * @return The response object constructed based on the entity.
	 */
	Response buildResponse(Entity entity);
}
