package com.zd.river.config.exception;

import lombok.Data;

/**
 * @author Exrickx
 */
@Data
public class RiverException extends RuntimeException {

    private String msg;

    public RiverException(String msg){
        super(msg);
        this.msg = msg;
    }
}
