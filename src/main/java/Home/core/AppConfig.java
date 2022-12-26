package Home.core;

import Home.core.discount.DiscountPolicy;
import Home.core.discount.FixDiscountPolicy;
import Home.core.discount.RateDiscountPolicy;
import Home.core.member.MemberService;
import Home.core.member.MemberServiceImpl;
import Home.core.member.MemoryMemberRepository;
import Home.core.order.OrderService;
import Home.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    public MemoryMemberRepository getMemberRepository() {
        System.out.println("call AppConfig.getMemberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
       return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
        //return null;
    }
    @Bean
    public DiscountPolicy getDiscountPolicy(){
        return new RateDiscountPolicy();
    }

}
