package com.onaple.jessietags;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableSingleData;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractSingleData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Optional;

public class TagDataManipulator extends AbstractSingleData<Integer,TagDataManipulator, TagDataManipulator.Immutable> {

    protected TagDataManipulator(Integer value) {
        super(value, JessieKeys.PRICE_TAG);
    }

    @Override
    protected Value<?> getValueGetter() {
        return Sponge.getRegistry().getValueFactory().createValue(JessieKeys.PRICE_TAG,getValue());
    }

    @Override
    public Optional<TagDataManipulator> fill(DataHolder dataHolder, MergeFunction overlap) {
        Optional<TagDataManipulator> data_ = dataHolder.get(TagDataManipulator.class);
        if (data_.isPresent()) {
            TagDataManipulator data = data_.get();
            TagDataManipulator finalData = overlap.merge(this, data);
            setValue(finalData.getValue());
        }
        return Optional.of(this);
    }

    @Override
    public Optional<TagDataManipulator> from(DataContainer container) {
        return from((DataView) container);
    }

    public Optional<TagDataManipulator> from(DataView view) {
        if (view.contains(JessieKeys.PRICE_TAG.getQuery())) {
            setValue(view.getInt(JessieKeys.PRICE_TAG.getQuery()).get());
            return Optional.of(this);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public TagDataManipulator copy() {
        return new TagDataManipulator(getValue());
    }

    @Override
    public Immutable asImmutable() {
        return new Immutable(getValue());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(JessieKeys.PRICE_TAG.getQuery(),getValue());
    }


    public static class Immutable extends AbstractImmutableSingleData<Integer,Immutable,TagDataManipulator>{

        protected Immutable(Integer value) {
            super(value, JessieKeys.PRICE_TAG);
        }

        @Override
        protected ImmutableValue<?> getValueGetter() {
            return Sponge.getRegistry().getValueFactory().createValue(JessieKeys.PRICE_TAG, getValue()).asImmutable();
        }

        @Override
        public TagDataManipulator asMutable() {
            return new TagDataManipulator(getValue());
        }

        @Override
        public int getContentVersion() {
            return 1;
        }

        @Override
        public DataContainer toContainer() {
            return super.toContainer().set(JessieKeys.PRICE_TAG.getQuery(),getValue());
        }
    }
    public static class Builder extends AbstractDataBuilder<TagDataManipulator> implements DataManipulatorBuilder<TagDataManipulator, Immutable> {
        Builder() {
            super(TagDataManipulator.class, 1);
        }

        @Override
        public TagDataManipulator create() {
            return new TagDataManipulator(0);
        }

        @Override
        public Optional<TagDataManipulator> createFrom(DataHolder dataHolder) {
            return create().fill(dataHolder);
        }

        @Override
        protected Optional<TagDataManipulator> buildContent(DataView container) throws InvalidDataException {
            return create().from(container);
        }
    }
}
