package org.roy.enumstest;



public enum OrderStatusExp implements Order{
    NO_PAY("未支付",0){
        @Override
        public void printOrderStatus() {
            System.out.println("未支付");
        }
    },
    PAY("已支付",1){
        @Override
        public void printOrderStatus() {
            System.out.println("已支付");
        }
    },
    REFUNDING("退款中",2){
        @Override
        public void printOrderStatus() {
            System.out.println("退款中");
        }
    },
    REFUNDED("退款成功",3){
        @Override
        public void printOrderStatus() {
            System.out.println("退款成功");
        }
    },
    FAIL_REFUNDED("退款失败",4){
        @Override
        public void printOrderStatus() {
            System.out.println("退款失败");
        }
    },
    ;

    private final String name;
    private final int status;

    private OrderStatusExp(String name,int status){
        this.name = name;
        this.status = status;
    }
}