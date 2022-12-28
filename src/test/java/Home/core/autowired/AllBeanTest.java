package Home.core.autowired;

import Home.core.AutoAppConfig;
import Home.core.discount.DiscountPolicy;
import Home.core.member.Grade;
import Home.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {


    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DisCountService.class);

        DisCountService disCountService = ac.getBean(DisCountService.class);

        Member member = new Member(1L, "userA", Grade.VIP);

        int discountPrice = disCountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(disCountService).isInstanceOf(DisCountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPolicy = disCountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPolicy).isEqualTo(2000);
    }


    static class DisCountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DisCountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policyList = " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);

        }
    }

}
