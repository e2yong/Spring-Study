package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /** for JdbcMemberRepository, JdbcTemplateMemberRepository
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */

    /** for JpaMemberRepository
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    /** for SpringDataJpaMemberRepository */
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 스프링 빈에 서비스 등록 = @Service
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /** 스프링 빈에 레포지토리 등록 = @Repository
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }
    */

    /** Aop
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
    */
}

