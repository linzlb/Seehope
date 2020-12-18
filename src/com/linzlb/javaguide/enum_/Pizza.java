package com.linzlb.javaguide.enum_;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 10:10
 * @Function: 自定义枚举方法
 */
public class Pizza {

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    //由于枚举类型确保JVM中仅存在一个常量实例，因此我们可以安全地使用 == 运算符比较两个变量
    public boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }

    // Methods that set and get the status variable.
    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    /**
     * 在 switch 语句中使用枚举类型
     */
    public int getDeliveryTimeInDays() {
        switch (status) {
            case ORDERED:
                return 5;
            case READY:
                return 2;
            case DELIVERED:
                return 0;
        }
        return 0;
    }

}
