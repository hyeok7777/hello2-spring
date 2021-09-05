package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {

    private int discountFixedAmout = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
        {
            return discountFixedAmout;
        }else
            return 0;
    }
}
