package com.envoy.biz.service;

import com.envoy.biz.util.ContextHelper;
import com.envoy.biz.util.HttpHelper;
import com.isyscore.isc.neo.util.TimeUtils;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shizi
 * @since 2022-06-14 20:40:12
 */
@Service
public class FrontService {

    @Value("${biz.url.d}")
    private String dUrl;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String adef(Boolean haveRedis, Boolean haveMysql) {
        if (haveRedis) {
            stringRedisTemplate.opsForValue().set("adef", TimeUtils.dateToString(new Date()), 1, TimeUnit.MINUTES);
        }

        Headers headers = Headers.of(ContextHelper.getData().getDataMapAssignValueType(String.class));
        return HttpHelper.getOfStandard(String.class, dUrl + "/api/d/ad/" + haveMysql, headers);
    }

    public String ba(Boolean haveRedis, Boolean haveMysql) {
        if (haveRedis) {
            stringRedisTemplate.opsForValue().set("ba", TimeUtils.dateToString(new Date()), 1, TimeUnit.MINUTES);
        }
        Headers headers = Headers.of(ContextHelper.getData().getDataMapAssignValueType(String.class));
        return HttpHelper.getOfStandard(String.class, dUrl + "/api/d/ad/" + haveMysql, headers);
    }
}
