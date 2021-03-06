package com.stu.sd.config;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ComplexShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue> shardingValues) {
        System.out.println("collection:" + collection + ",shardingValues:" + shardingValues);
        Collection<Long> orderIdValues;
        if(collection.iterator().next().startsWith("t_order")){
            orderIdValues=getShardingValue(shardingValues, "id");
        }else{
            orderIdValues=getShardingValue(shardingValues, "order_id");
        }
        Collection<Long> userIdValues = getShardingValue(shardingValues, "user_id");
        List<String> shardingSuffix = new ArrayList<>();

        // user_id，order_id分片键进行分表
        for (long userId : userIdValues) {
            for (long orderId : orderIdValues) {
                String suffix = userId % 2 + "_" + orderId % 2;
                for (String s : collection) {
                    if (s.endsWith(suffix)) {
                        shardingSuffix.add(s);
                    }
                }
            }
        }
        return shardingSuffix;
    }

    private Collection<Long> getShardingValue(Collection<ShardingValue> shardingValues, final String key) {
        Collection<Long> valueSet = new ArrayList<>();
        Iterator<ShardingValue> iterator = shardingValues.iterator();
        while (iterator.hasNext()) {
            ShardingValue next = iterator.next();
            if (next instanceof ListShardingValue) {
                ListShardingValue value = (ListShardingValue) next;
                // user_id，order_id分片键进行分表
                if (value.getColumnName().equals(key)) {
                    return value.getValues();
                }
            }
        }
        return valueSet;
    }
}
