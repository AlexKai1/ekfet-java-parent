package com.ekfet.boothystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestContrller {

    @GetMapping("/{id}/getUserById")
    @HystrixCommand(fallbackMethod = "getUserIdBack")
    public ApiResponse<String> getUserId(@PathVariable("id") String id) throws Exception {
        if (id.equals("1")) {
            return new ApiResponse<>("1");
        } else {
            throw new IllegalAccessException("1122");
        }

    }

    protected ApiResponse<String> getUserIdBack() {
        log.info("error");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(444);
        apiResponse.setMessage("fail");
        return apiResponse;
    }
}
