package vn.aliviet.order.exception;

/**
 * Created by windluffy on 10/11/2015.
 */
public class CreateOrderException extends Exception {
    private CreateOrderExceptionCode exCode;
    public enum CreateOrderExceptionCode {
        EMPTY_PRODUCT,
        CUSTOMER_NOT_EXIST,
        SYSTEM_ERROR
    }

    public CreateOrderException(CreateOrderExceptionCode createOrderExceptionCode) {
        this.exCode = createOrderExceptionCode;
    }
}
