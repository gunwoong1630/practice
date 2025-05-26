package singleton;

import java.security.Signature;

public class singletonService {
    private static final singletonService instance = new singletonService();

    public static singletonService getInstance() {
        return instance;
    }

    private singletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
