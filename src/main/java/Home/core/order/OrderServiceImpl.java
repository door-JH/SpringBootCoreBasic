package Home.core.order;

import Home.core.discount.DiscountPolicy;
import Home.core.member.Member;
import Home.core.member.MemberRepository;
import Home.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
//    @Autowired
    private final MemberRepository memberRepository;
//    @Autowired
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository){
//        System.out.println("memberRepository = " + memberRepository);
//        this.discountPolicy = discountPolicy;
//    }

//  @Autowired 생성자가 1개일시 생략가능.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1 memberRepository = " + memberRepository);
        System.out.println("1 discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    
    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
