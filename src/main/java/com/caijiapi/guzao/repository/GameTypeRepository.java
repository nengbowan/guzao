package com.caijiapi.guzao.repository;

import com.caijiapi.guzao.entity.GameType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTypeRepository extends CrudRepository<GameType , String> {
    public GameType findByName(String name);

    public GameType findByCode(String code);
}
