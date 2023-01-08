package Home.core.scan;

import Home.core.AutoAppConfig;
import Home.core.member.MemberRepository;
import Home.core.member.MemberService;
import Home.core.member.MemberServiceImpl;
import Home.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

//        MemberRepository MemberRepository = ac.getBean(MemberRepository.class);
//        Assertions.assertThat(MemberRepository).isInstanceOf(MemberRepository.class);
//
//        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
//        MemberRepository memberRepository = bean.getMemberRepository();
//        System.out.println("memberRepository = " + memberRepository);

    }


}
