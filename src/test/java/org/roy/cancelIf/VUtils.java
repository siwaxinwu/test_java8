package org.roy.cancelIf;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/14 19:40
 */
public class VUtils {
    /**
     *  如果参数为true抛出异常
     *
     * @param b
     * @return com.example.demo.func.ThrowExceptionFunction
     **/
    public static ThrowExceptionFunction isTure(boolean b){

        return (errorMessage) -> {
            if (b){
                throw new RuntimeException(errorMessage);
            }
        };
    }

  public static void main(String[] args) {
      ThrowExceptionFunction result = VUtils.isTure(true);
      result.throwMessage("throw message");
  }
}
