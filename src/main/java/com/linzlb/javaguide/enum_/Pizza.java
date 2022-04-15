package com.linzlb.javaguide.enum_;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2020/12/18 10:10
 * @Function:
 */
public class Pizza {

    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

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
