package hello.core.order;

public interface OrderService {

    /**
     *  주문 생성
     * @return 주문 결과
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
