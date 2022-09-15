package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


// 스프링 컨테이너가 빈을 생성하는 과정
// BeanDefinitionReader 가 읽어 들여서 bean 에 대한 메타 정보를 생성 (BeanDefinition)
// 스프링이 다양한 형태의 설정 정보를 BeanDefinition 으로 추상화해서 사용한다 !
public class BeanDifinition {

//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    GenericXmlApplicationContext ac = new GenericXmlApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinition = " + beanDefinition +
                        "beanDefinition = " + beanDefinition);
            }
        }
    }
}
