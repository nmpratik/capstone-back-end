package com.pra.ems.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AppResponse<T> {
    @Builder.Default
    private final String sts = "SUCCESS";
    private String msg;
    private T bd;

}
