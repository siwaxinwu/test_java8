package org.roy.enumstest;

/**
 * 订单状态
 *
 * @author xmly
 * @date 2021/09/21
 */
enum OrderStatus{
    NO_PAY("未支付",0),
    PAY("已支付",1){
        @Override
        public void printOrderStatus() {
            System.out.println("已支付");
        }
    },
    REFUNDING("退款中",2),
    REFUNDED("退款成功",3),
    FAIL_REFUNDED("退款失败",4),
    ;

    private final String name;
    private final int status;

    private OrderStatus(String name,int status){
        this.name = name;
        this.status = status;
    }

    public void printOrderStatus(){
        System.out.println("打印订单状态");
    }
}


public class EnumTest {
    public static void main(String[] args) {
        OrderStatus.PAY.printOrderStatus();
        OrderStatus.NO_PAY.printOrderStatus();
    }
}
