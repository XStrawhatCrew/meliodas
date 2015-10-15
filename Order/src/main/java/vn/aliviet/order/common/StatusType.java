package vn.aliviet.order.common;

/**
 * Created by windluffy on 10/1/2015.
 */
public class StatusType {
    public static final int PRODUCT_REJECTED = 12;
    public static final int PRODUCT_NOT_DONE = 11;
    public static final int PRODUCT_DONE = 10;
    public static final int ORDER_REJECTED = 22;
    public static final int ORDER_NOT_DONE = 21;
    public static final int ORDER_DONE = 20;

    public static String getTitle(int statusId) {
        switch (statusId) {
            case PRODUCT_REJECTED:
                return "product rejected";
            case PRODUCT_NOT_DONE:
                return "product not done";
            case PRODUCT_DONE:
                return "product done";
            case ORDER_REJECTED:
                return "order rejected";
            case ORDER_NOT_DONE:
                return "order not done";
            default:
                return "order done";
        }
    }
}
