package com.ekfet.spring.webflux.config;

import com.ekfet.webflux.webflux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: RoutingConfiguration
 * @date 2018/12/21 10:43
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
        return route(GET("/user").and(accept(APPLICATION_JSON)), userHandler::getUser)
                .andRoute(GET("/user/customers").and(accept(APPLICATION_JSON)), userHandler::getUserCustomers)
                .andRoute(DELETE("/user").and(accept(APPLICATION_JSON)), userHandler::deleteUser);
    }


}
