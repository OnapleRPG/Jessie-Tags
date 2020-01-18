package com.onaple.jessietags;

import com.google.inject.internal.cglib.proxy.$MethodProxy;
import com.onaple.itemizer.data.beans.ItemNbtFactory;
import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;

import java.util.List;

public class TagFactory implements ItemNbtFactory {

    @Setting("price")
    private Integer price;

    @Override
    public Key getKey() {
        return JessieKeys.PRICE_TAG;
    }

    @Override
    public String getName() {
        return "Jessie's tags";
    }

    @Override
    public DataManipulator<?, ?> constructDataManipulator() {
        return new TagDataManipulator(price);
    }

    @Override
    public int compareTo(ItemNbtFactory itemNbtFactory) {
        return 0;
    }
}
