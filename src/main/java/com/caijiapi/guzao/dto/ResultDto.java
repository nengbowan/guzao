package com.caijiapi.guzao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> {

    @Builder.Default
    private Boolean success = Boolean.TRUE;

    private T data;

    private String message;
}
