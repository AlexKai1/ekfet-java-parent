package com.ekfet.store.user.srv.controller;

import com.ekfet.cloud.framework.response.ResultResponse;
import com.ekfet.store.user.client.feign.UserFeignClient;
import com.ekfet.store.user.client.response.UserInfo;

public class UserSrvController implements UserFeignClient {

    @Override
    public ResultResponse<UserInfo> getUserById(String id) {
        return null;
    }
}
