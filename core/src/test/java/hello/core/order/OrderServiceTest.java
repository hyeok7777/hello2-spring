package hello.core.order;

import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());

    @Test
    public void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
