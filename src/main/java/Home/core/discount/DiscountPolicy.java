package Home.core.discount;

import Home.core.member.Member;

public interface DiscountPolicy {

    /**
     *
     *
     * @return 할인 대상 정책
     */
    int discount(Member member, int price);
}
