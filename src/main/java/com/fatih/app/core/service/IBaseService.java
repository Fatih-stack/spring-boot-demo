package com.fatih.app.core.service;

import com.fatih.app.core.common.model.BaseInfo;
import com.fatih.app.core.exception.AppServiceException;
import com.fatih.app.core.persist.BaseEntity;

import java.util.List;

public interface IBaseService<E extends BaseEntity<I>, I extends BaseInfo> {

    I getById(Long id) throws AppServiceException;

    I create(I info) throws AppServiceException;

    I update(I info) throws AppServiceException;

    void delete(Long id) throws AppServiceException;

    List<I> getList() throws AppServiceException;

}
