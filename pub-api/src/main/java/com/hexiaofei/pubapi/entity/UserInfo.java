package com.hexiaofei.pubapi.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lcyj
 * @date 2022-02-27 12:46
 * @since
 */
@Getter
@Setter
public class UserInfo implements Serializable {

    private String userid;

    private String username;

    private String servers;

    private Integer age;

    private String idNo;

    private String addr;
}
