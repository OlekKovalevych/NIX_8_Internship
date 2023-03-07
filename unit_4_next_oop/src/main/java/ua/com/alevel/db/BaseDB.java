package ua.com.alevel.db;

import ua.com.alevel.entiti.BaseEntity;
import ua.com.alevel.entiti.User;

import java.util.Collection;
import java.util.List;

public interface BaseDB<ENTITY  extends BaseEntity> {


    void create(ENTITY entity);

    void update(ENTITY entity);

    void delete(String id);

    ENTITY findById(String id);

    Collection<ENTITY> finalAll();

}