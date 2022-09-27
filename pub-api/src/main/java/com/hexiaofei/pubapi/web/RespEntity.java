package com.hexiaofei.pubapi.web;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lcyj
 * @date 2022-03-06 16:49
 * @since
 */
@Getter
@Setter
public class RespEntity<T> {

    private String code;

    private String msg;

    private T date;
}
