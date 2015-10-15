package vn.aliviet.order.common;

/**
 * Created by windluffy on 10/1/2015.
 */
public class RoleType {
    public static final int ADMINISTRATOR = 0;
    public static final int STAFF = 1;
    public static final int CUSTOMER = 2;

    public static String getTitle(int roleId) {
        switch (roleId) {
            case ADMINISTRATOR:
                return "administrator";
            case STAFF:
                return "staff";
            default:
                return "customer";
        }
    }
}
