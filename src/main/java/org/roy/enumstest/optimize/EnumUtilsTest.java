package org.roy.enumstest.optimize;


import com.alibaba.fastjson.JSON;

/**
 * @description: 枚举优化测试
 * @author: Ding Yawu
 * @create: 2021/2/20 15:42
 */
public class EnumUtilsTest {



    enum IntMsgEnum implements CodeMsgEnum<Integer> {
        INT1(1, "类型测试1"),
        INT2(2, "类型测试2");

        private final Integer code;
        private final String msg;

        IntMsgEnum(Integer value, String name) {
            this.code = value;
            this.msg = name;
        }

        @Override
        public String getMsg() {
            return this.msg;
        }

        @Override
        public Integer getCode() {
            return this.code;
        }
    }

  public static void main(String[] args) {
      String string = JSON.toJSONString(null);
      System.out.println(string);
      System.out.println(EnumUtils.isExist(IntMsgEnum.values(), 2));
    System.out.println(EnumUtils.getMsgByCode(IntMsgEnum.values(), 2));
    System.out.println(EnumUtils.getCodeByMsg(IntMsgEnum.values(), "类型测试2"));
    System.out.println(EnumUtils.getEnumByCode(IntMsgEnum.values(), 1));

  }

}

