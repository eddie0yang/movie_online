package com.eddie.movie_online_common.service;

/**
 * redis操作Service,对象和数组都以json形式进行存储
 * @author Eddie
 * @date 2022/01/13
 */
public interface RedisService {

    /**
     * 存储数据
     *
     * @param key
     * @param value
     * @return void
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key
     * @return String
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key
     * @param expire
     * @return boolean
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key
     * @return void
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key
     * @param delta 自增步长
     * @return Long
     */
    Long increment(String key, long delta);

}

