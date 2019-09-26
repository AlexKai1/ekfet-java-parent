package com.ekfet.store.user.client.feign;


import com.ekfet.cloud.framework.response.ResultResponse;
import com.ekfet.store.user.client.response.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "userFeignClient")
public interface UserFeignClient {

    @PostMapping("/user/{id}/byId")
    ResultResponse<UserInfo> getUserById(@PathVariable("id") String id);
}
