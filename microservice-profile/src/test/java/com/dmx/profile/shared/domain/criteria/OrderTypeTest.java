package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.EnumTest;

public final class OrderTypeTest {
    public static OrderType random(){
        return EnumTest.random(OrderType.class);
    }

    public static void main(String[] args) {
        System.out.println(random().value());
    }
}
