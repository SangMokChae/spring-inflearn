package hello.core.singleton;

public class StateFulService {
    
    private int price; // 상태를 유지하는 필드 10000 -> 20000
    
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!!
    }

    // 무상태로 설계하기기
   public int order1(String name, int price) {
       System.out.println("name = " + name + " price = " + price);
       this.price = price; //여기가 문제!!
       return price;
    }

    public int getPrice() {
        return price;
    }
}
