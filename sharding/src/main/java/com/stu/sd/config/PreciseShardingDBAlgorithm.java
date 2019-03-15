package com.stu.sd.config;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public class PreciseShardingDBAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Long> shardingValue) {
        for (String each : databaseNames) {
            if (each.endsWith(shardingValue.getValue() % databaseNames.size() + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
