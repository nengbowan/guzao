package com.caijiapi.guzao.service;

import com.caijiapi.guzao.entity.GameType;
import com.caijiapi.guzao.exception.ServiceException;
import com.caijiapi.guzao.repository.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class GameTypeService {
    @Autowired
    private GameTypeRepository gameTypeRepository;

    /**
     * 创建彩种分类
     * @param gameType
     * @throws ServiceException
     */
    public void create(GameType gameType)throws ServiceException{
        if(StringUtils.isEmpty(gameType.getName())){
            throw new ServiceException("create name must not be null");
        }
        if(StringUtils.isEmpty(gameType.getCode())){
            throw new ServiceException("create code must not be null");
        }
        //验证名称
        GameType type = this.gameTypeRepository.findByName(gameType.getName());
        if(type != null){
            throw new ServiceException("create name has exist!");
        }
        type = this.gameTypeRepository.findByCode(gameType.getCode());
        if(type != null){
            throw new ServiceException("create code has exist!");
        }
        this.gameTypeRepository.save(gameType);
    }

    /**
     * 单个删除　批量删除应用场景不高
     * @param id
     */
    public void deleteById(String id){
        //验证当前分类下是否有彩种
        Optional<GameType> type = this.gameTypeRepository.findById(id);
        if(!type.isPresent()){
            return;
        }
        String gameName = type.get().getName();

        this.gameTypeRepository.deleteById(id);
    }

    /**
     * 修改彩种分类
     * @param gameType
     */
    public void modify(GameType gameType) throws ServiceException{
        if(StringUtils.isEmpty(gameType.getName())){
            throw new ServiceException("modify name must not be null");
        }
        if(StringUtils.isEmpty(gameType.getCode())){
            throw new ServiceException("modify code must not be null");
        }
        //验证名称
        GameType type = this.gameTypeRepository.findByName(gameType.getName());
        //验证是否名称存在　防止创建新彩种分类
        if(type == null){
            throw new ServiceException("modify name must be exist!");
        }
        //验证编码是否更改
        if(type.getCode().equals(gameType.getCode())){
            return;
        }
        this.gameTypeRepository.save(gameType);

    }
}
