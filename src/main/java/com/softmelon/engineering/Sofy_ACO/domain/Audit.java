package com.softmelon.engineering.Sofy_ACO.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;

public abstract class Audit implements Auditable<String, Long, LocalDateTime>, Serializable, IModel {

	@CreatedBy
	@Column(updatable = false)
	protected String createdBy;

	@CreatedDate
	@Column(updatable = false)
	protected LocalDateTime createdDate;

	@LastModifiedBy
	protected String lastModifiedBy;

	@LastModifiedDate
	protected LocalDateTime lastModifiedDate;

	public Optional<String> getCreatedBy() {
		return Optional.ofNullable(createdBy);
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Optional<LocalDateTime> getCreatedDate() {
		return Optional.ofNullable(createdDate);
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Optional<String> getLastModifiedBy() {
		return Optional.ofNullable(lastModifiedBy);
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Optional<LocalDateTime> getLastModifiedDate() {
		return Optional.ofNullable(lastModifiedDate);
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public boolean isNew() {
		return Objects.isNull(getId());
	}
}
