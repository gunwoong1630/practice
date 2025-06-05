package com.example.core.discount;

import com.example.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return price;
    }
}
