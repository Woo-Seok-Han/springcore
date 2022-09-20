package hello.core.scan.filter;

import java.lang.annotation.*;

// MyIncludeComponent 어노테이션이 붙은 애는 컴포넌트로 추가 할 것이다
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
