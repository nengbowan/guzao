package com.caijiapi.guzao.jpaSpec;

import com.caijiapi.guzao.entity.Game;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameSpecialficaiton implements Specification<Game> {

    private Game game ;
    public GameSpecialficaiton(Game game){
        this.game = game;
    }
    @Override
    public Predicate toPredicate(Root<Game> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(StringUtils.isNotEmpty(game.getName())){
            Path<String> namePredicate =
            }
        }

        return null;
    }


}
