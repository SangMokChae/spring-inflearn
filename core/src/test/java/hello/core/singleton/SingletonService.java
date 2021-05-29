package hello.core.singleton;

public class SingletonService {

    // 자기자신을 static으로 싱글톤으로 생성 // static => class level로 올라가서 하나만 만들어져 올라간다.
    // 자바가 뜨면서 static영역을 초기화 하면서 instance에 new 생성한것을 가지고
    // 참조를 꺼내는 방법은 getInstance()로만 꺼내서 사용 가능하다.
    private static final SingletonService instance = new SingletonService();

    // 조회시에 사용
    public static SingletonService getInstance() {
        return instance;
    }

    // new 키워드로 생성하는 것을 막는다.
    private SingletonService() {
    }

    /* singleton이 아닐 때의 문제점
    public static void main(String[] args) {
        // 이처럼 임의로 생성가능하다.
        SingletonService singletonService1 = new SingletonService();
        SingletonService singletonService2 = new SingletonService();
    }
     */

    public void loggic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
