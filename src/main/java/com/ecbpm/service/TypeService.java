package com.ecbpm.service;

import com.ecbpm.pojo.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAll();

    int addType(Type type);

    void updateType(Type type);
}
