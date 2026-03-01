package com.dmx.social_graph.type.domain;

import java.util.Objects;

public final class Type {
    private final TypeId id;
    private final TypeLabel label;

    public Type(TypeId id, TypeLabel label) {
        this.id = id;
        this.label = label;
    }

    public Type() {
        this.id = null;
        this.label = null;
    }
    public static Type fromPrimitives(TypeDTO type) {
        return new Type(new TypeId(type.id()), new TypeLabel(type.label()));
    }

    public TypeDTO toPrimitives() {
        return new TypeDTO(this.id.value(), this.label.value());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id.equals(type.id) && label.equals(type.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", label=" + label +
                '}';
    }
}
