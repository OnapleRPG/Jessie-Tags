package com.onaple.jessietags;

import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.TypeTokens;

public class JessieKeys {

    public static  Key<Value<Integer>> PRICE_TAG;
    public JessieKeys(){
        PRICE_TAG = Key.builder()
                .id("price.tag")
                .name("Price tag")
                .query(DataQuery.of(".","price"))
                .type(TypeTokens.INTEGER_VALUE_TOKEN)
                .build();
    }
}
