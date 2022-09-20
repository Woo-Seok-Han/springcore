package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 어노테이션 정의를 보면 @Component 가 있고
// componentscan 은 component 어노테이션이 붙은 클래스의 객체는 모두 자동 빈 등록을 해준다
// 테스트를 위하여 configuration 이 붙은 클래스는 제외한다
@Configuration
@ComponentScan(
        // 해당 경로에서 부터 컴포넌트를 스캔함 (시작 위치를 지정함)
        // 프로젝트가 크면 클수록 전부 스캔하면 느려짐
        // 지정하지 않으면 @Configuration 이 존재하는 클래스와 같은 레벨부터 검색을 한다 ( hello.core )
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
