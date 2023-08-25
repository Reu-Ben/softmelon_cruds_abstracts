package com.softmelon.engineering.Sofy_ACO.service.helper;

import org.springframework.stereotype.Component;

import com.softmelon.engineering.Sofy_ACO.domain.IModel;
import com.softmelon.engineering.Sofy_ACO.request.abstracts.BaseAbstractRequest;

@Component
public interface IHelper<Entity extends IModel, Request extends BaseAbstractRequest> {

	public Entity buildEntityRequest(Entity entity, Request request);

}