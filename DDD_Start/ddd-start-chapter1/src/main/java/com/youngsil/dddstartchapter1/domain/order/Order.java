package com.youngsil.dddstartchapter1.domain.order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Order {
    private List<OrderLine> orderLines;
    private int totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState orderState;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
        List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
    }

    private void calculateTotalAmounts() {
        totalAmounts = orderLines.stream()
                .map(OrderLine::getAmounts)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalStateException("no OrderLine"));
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if(orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    //출고 상태로 변경
    public void changeShipped(){
        this.orderState = OrderState.SHIPPED;
    }

    //배송지 정보 변경
    private void setShippingInfo(ShippingInfo shippingInfo) {
        if(shippingInfo == null) {
            throw  new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    private void verifyNotYetShipped() {
        if(this.orderState != OrderState.PAYMENT_WAITING || this.orderState != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }


    //주문 취소 하기
    public void cancel(){
        verifyNotYetShipped();
        this.orderState = OrderState.CANCELED;
    }

    //결제 완료로 변경
    public void completedPayment(){
        this.orderState = OrderState.PREPARING;
    }
}
