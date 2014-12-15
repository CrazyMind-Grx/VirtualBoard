package com.vb.angel.vb_socketii;

import java.io.Serializable;

/**
 * Created by Angel on 14/12/2014.
 */
public class Message implements Serializable{
    private static final long serialVersionUID = -8136994035787071864L;
    private String sender;
    private String message;
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
