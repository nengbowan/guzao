package com.caijiapi.guzao.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_game_type")
public class GameType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private String code;
}
