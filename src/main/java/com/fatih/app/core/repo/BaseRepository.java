package com.fatih.app.core.repo;

import com.fatih.app.core.common.model.BaseInfo;
import com.fatih.app.core.persist.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<E extends BaseEntity<I>, I extends BaseInfo> extends CrudRepository<E, Long> {

}
