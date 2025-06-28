package com.dmx.profile.shared.domain.criteria;

import com.dmx.profile.shared.domain.EnumMother;

public final class OrderTypeTest {
    public static OrderType random(){
        return EnumMother.random(OrderType.class);
    }

    public static void main(String[] args) {
        System.out.println(random().value());
    }
}
