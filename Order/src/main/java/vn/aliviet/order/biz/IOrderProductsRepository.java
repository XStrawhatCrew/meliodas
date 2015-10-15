package vn.aliviet.order.biz;

import vn.aliviet.order.entity.Product;

import java.util.List;

/**
 * Created by windluffy on 10/1/2015.
 */
public interface IOrderProductsRepository {
    /***
     *
     * @param customerId the id of customer
     * @param products the products which customer create
     * @return orderId is created in database or -1 if create fail
     */
    int createOrder(int customerId, List<Product> products);

    /***
     * get the product by product id
     * @param productId the id of product
     * @return the product is identifier by product id
     */
    Product getProductByProductId(int productId);

    
}
