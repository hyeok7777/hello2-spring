package hello.core.singleton;

public class StatefulService {
    // 상태를 유지하는 필드
    private int price;

    public void order(String name, int price) {
        System.out.print("name = " + name);
        System.out.println("  price = " + price);
        // 문제되는 부분
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
