package hello.core.singleton;

// 생성자를 private 으로 막아 놓음으로써
// application 실행 시에 class load 되면서 자체 객체를 한번만 생성한 후
// getInstance 로 한개의 객체만을 사용
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){};

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
