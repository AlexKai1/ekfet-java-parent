package com.ekfet.store.user.client.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    public String id;
    private String username;
    private int sex;
    private String email;
}
