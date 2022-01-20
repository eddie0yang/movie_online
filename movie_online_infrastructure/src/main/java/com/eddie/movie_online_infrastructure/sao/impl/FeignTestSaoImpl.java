package com.eddie.movie_online_infrastructure.sao.impl;

import com.eddie.movie_online_infrastructure.sao.FeignTestSao;
import com.eddie.movie_online_infrastructure.sao.api.FeignTestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeignTestSaoImpl implements FeignTestSao {

    @Autowired
    private FeignTestApi feignTestApi;

    @Override
    public String testFeign(int i) {
        return feignTestApi.getUser(i);
    }
}
