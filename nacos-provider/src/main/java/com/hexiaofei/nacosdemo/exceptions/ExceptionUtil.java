package com.hexiaofei.nacosdemo.exceptions;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author lcyj
 * @date 2022-01-31 16:50
 * @since
 */
public class ExceptionUtil {

    public String handleException(BlockException blcokException){
        return "sentinel 降级……";
    }
}
