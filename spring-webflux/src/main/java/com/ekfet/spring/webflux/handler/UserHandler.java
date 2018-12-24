package com.ekfet.spring.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: UserHander
 * @date 2018/12/21 10:36
 */
@Component
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest request) {
       final Map<String,Object> user=new HashMap<>();
        user.put("userName","zhangsan");
        Mono<Map> mapMono=request.bodyToMono(Map.class);
        System.out.println( mapMono.toString());
        request.headers().accept().add(MediaType.APPLICATION_JSON_UTF8);
        Flux<Map> requestData= request.bodyToFlux(Map.class);
         return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(user);
    }

    public Mono<ServerResponse> getUserCustomers(ServerRequest request) {
        final Map<String,Object> user=new HashMap<>();
        user.put("getUserCustomers","12");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(user);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        final Map<String,Object> user=new HashMap<>();
        user.put("deleteUser",true);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(user);
    }
}
