package ua.com.alevel.dao;

import ua.com.alevel.entiti.BaseEntity;

import java.util.Collection;

public interface BaseDao<ENTITY  extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String id);
    ENTITY findById(String id);
    Collection<ENTITY> finalAll();

}
