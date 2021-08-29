package org.roy;

/**
 * 利用的是抽象类 + 枚举来完成不同的策略具体实现
 * @author dingyawu
 * @version 1.0
 * @date created in 2021-08-17 19:50
 */
public enum SaveStrategyEnum {
    DB("db") {
        @Override
        public void save(Object obj) {
            System.out.println("save in db:" + obj);
        }
    },
    FILE("file") {
        @Override
        public void save(Object obj) {
            System.out.println("save in file: " + obj);
        }
    },
    OSS("oss") {
        @Override
        public void save(Object obj) {
            System.out.println("save in oss: " + obj);
        }
    };

    private String type;

    SaveStrategyEnum(String type) {
        this.type = type;
    }

    public abstract void save(Object obj);

    public static SaveStrategyEnum typeOf(String type) {
        for (SaveStrategyEnum strategyEnum: values()) {
            if (strategyEnum.type.equalsIgnoreCase(type)) {
                return strategyEnum;
            }
        }
        return null;
    }

    public static void save(String type, Object data) {
        SaveStrategyEnum strategyEnum = SaveStrategyEnum.typeOf(type);
        if (strategyEnum != null) {
            strategyEnum.save(data);
        }
    }

    public static void main(String[] args) {
        save("oss", "dingyawu");
    }
}


