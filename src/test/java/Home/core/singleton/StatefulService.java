package Home.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 , state

//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
//    }


    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        // this.price = price; 이부분이 문제
        return price; //stateless
    }

//    public int getPrice() {
//        return price;
//    }
}
