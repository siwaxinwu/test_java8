package org.roy.enumstest.optimize;




import org.apache.commons.lang.StringUtils;

import java.util.Objects;


/**
 * @description: 枚举常用工具类
 * @author: Ding Yawu
 * @create: 2021/2/20 15:42
 */
public final class EnumUtils {

    /**
     * 判断枚举值是否存在于指定枚举数组中
     *
     * @param enums 枚举数组
     * @param code 枚举值
     * @return 是否存在
     */
    public static <T> boolean isExist(CodeEnum<T>[] enums, T code) {
        if (code == null) {
            return false;
        }
        for (CodeEnum<T> e : enums) {
            if (Objects.equals(e.getCode(), code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断枚举值是否存与指定枚举类中
     *
     * @param enumClass 枚举类
     * @param value     枚举值
     * @param <E>       枚举类型
     * @param <V>       值类型
     * @return true：存在
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<? extends CodeEnum<V>>, V> boolean isExist(Class<E> enumClass, V value) {
        for (Enum<? extends CodeEnum<V>> e : enumClass.getEnumConstants()) {
            if (((CodeEnum<V>) e).getCode().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据枚举值获取其对应的名字
     *
     * @param enums 枚举列表
     * @param code 枚举值
     * @return 枚举名称
     */
    public static <T> String getMsgByCode(CodeMsgEnum<T>[] enums, T code) {
        if (code == null) {
            return null;
        }
        for (CodeMsgEnum<T> e : enums) {
            if (Objects.equals(e.getCode(), code)) {
                return e.getMsg();
            }
        }
        return null;
    }

    /**
     * 根据枚举名称获取对应的枚举值
     *
     * @param enums 枚举列表
     * @param msg  枚举名
     * @return 枚举值
     */
    public static <T> T getCodeByMsg(CodeMsgEnum<T>[] enums, String msg) {
        if (StringUtils.isEmpty(msg)) {
            return null;
        }
        for (CodeMsgEnum<T> e : enums) {
            if (Objects.equals(e.getMsg(), msg)) {
                return e.getCode();
            }
        }
        return null;
    }

    /**
     * 根据枚举值获取对应的枚举对象
     *
     * @param enums 枚举列表
     * @return 枚举对象
     */
    @SuppressWarnings("unchecked")
    public static <E extends Enum<? extends CodeEnum<V>>, V> E getEnumByCode(E[] enums, V code) {
        for (E e : enums) {
            if (Objects.equals(((CodeEnum<V>) e).getCode(), code)){
                return e;
            }
        }
        return null;
    }

    /**
     * 根据枚举值获取对应的枚举对象
     *
     * @param enumClass 枚举class
     * @return 枚举对象
     */
    public static <E extends Enum<? extends CodeEnum<V>>, V> E getEnumByCode(Class<E> enumClass, V code) {
        return getEnumByCode(enumClass.getEnumConstants(), code);
    }
}
