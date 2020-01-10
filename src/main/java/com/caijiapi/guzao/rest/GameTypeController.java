package com.caijiapi.guzao.rest;

import com.caijiapi.guzao.dto.ResultDto;
import com.caijiapi.guzao.entity.GameType;
import com.caijiapi.guzao.exception.ServiceException;
import com.caijiapi.guzao.service.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/gameType")
@RestController
public class GameTypeController {

    @Autowired
    private GameTypeService gameTypeService;

    @PostMapping(value = "/")
    public ResultDto<Object> create(@RequestBody(required = true) GameType param) throws ServiceException {
        gameTypeService.create(param);
        return ResultDto.builder().build();
    }

    @PutMapping(value = "/")
    public ResultDto<Object> modify(@RequestBody(required = true) GameType param)throws ServiceException{
        gameTypeService.modify(param);
        return ResultDto.builder().build();
    }

    @DeleteMapping(value = "/")
    public ResultDto<Object> delete(String id){
        gameTypeService.deleteById(id);
        return ResultDto.builder().build();
    }

}
