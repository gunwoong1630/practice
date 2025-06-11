package com.example.core.scan;

import com.example.core.AutoAppConfig;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberServiceImpl bean = ac.getBean(MemberServiceImpl.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);

        OrderServiceImpl bean1 = ac.getBean(OrderServiceImpl.class);
        System.out.println(bean1.getMemberRepository());
    }
}
