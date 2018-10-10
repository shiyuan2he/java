package com.hsy.java.cache.redis.spring.string;

import com.askingdata.y.cache.redis.spring.ISpringRedisInterface;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;

import java.util.List;
import java.util.Map;

public interface IGeoOperationsBase extends ISpringRedisInterface {
    Long geoAdd(String var1, Point var2, String var3);

    Long geoAdd(String var1, RedisGeoCommands.GeoLocation<String> var2);

    Long geoAdd(String var1, Map<String, Point> var2);

    Long geoAdd(String var1, Iterable<RedisGeoCommands.GeoLocation<String>> var2);

    Distance geoDist(String var1, String var2, String var3);

    Distance geoDist(String var1, String var2, String var3, Metric var4);

    List<String> geoHash(String var1, String... var2);

    List<Point> geoPos(String var1, String... var2);

    GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadius(String var1, Circle var2);

    GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadius(String var1, Circle var2, RedisGeoCommands.GeoRadiusCommandArgs var3);

    GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadiusByMember(String var1, String var2, double var3);

    GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadiusByMember(String var1, String var2, Distance var3);

    GeoResults<RedisGeoCommands.GeoLocation<String>> geoRadiusByMember(String var1, String var2, Distance var3, RedisGeoCommands.GeoRadiusCommandArgs var4);

    Long geoRemove(String var1, String... var2);
}
