package hello.core.order;

// 요구 사항 주문 구현함
public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
