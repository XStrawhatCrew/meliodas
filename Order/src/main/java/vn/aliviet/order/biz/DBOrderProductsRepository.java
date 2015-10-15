package vn.aliviet.order.biz;

import vn.aliviet.order.common.StatusType;
import vn.aliviet.order.entity.Product;

import java.sql.*;
import java.util.List;

/**
 * Created by windluffy on 10/1/2015.
 */
public class DBOrderProductsRepository extends DBBase implements IOrderProductsRepository {

    public DBOrderProductsRepository(Connection conn) {
        super(conn);
    }

    @Override
    public int createOrder(int customerId, List<Product> products) {
        int orderIdCreated = -1;

        String qInsertOrderBill = "INSERT INTO order_bill (customer_id, status_id) VALUES (?, ?)";
        String qInsertProducts = "INSERT INTO product (link_source, shop_name, color, notes, size, quantity, price, status_id, order_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement psInsertOrderBill = null;
        PreparedStatement psInsertProducts = null;
        Savepoint savepoint = null;
        try {
            conn.setAutoCommit(false);
            savepoint = conn.setSavepoint();

            //insert order bill
            psInsertOrderBill = conn.prepareStatement(qInsertOrderBill, PreparedStatement.RETURN_GENERATED_KEYS);
            psInsertOrderBill.setInt(1, customerId);
            psInsertProducts.setInt(2, StatusType.ORDER_NOT_DONE);
            psInsertProducts.executeUpdate();

            //get order id which is generated when insert order_bill
            ResultSet rsOrderIdCreated = psInsertOrderBill.getGeneratedKeys();
            if (rsOrderIdCreated != null && rsOrderIdCreated.next()) {
                orderIdCreated = rsOrderIdCreated.getInt(1);
            } else {
                throw new Exception();
            }

            //insert products
            psInsertProducts = conn.prepareStatement(qInsertProducts);
            for (Product p : products) {
                psInsertProducts.setString(1, p.getLinkSource());
                psInsertProducts.setString(2, p.getShopName());
                psInsertProducts.setString(3, p.getColor());
                psInsertProducts.setString(4, p.getNotes());
                psInsertProducts.setString(5, p.getSize());
                psInsertProducts.setInt(6, p.getQuantity());
                psInsertProducts.setInt(7, p.getPrice());
                psInsertProducts.setInt(8, StatusType.PRODUCT_NOT_DONE);
                psInsertProducts.setInt(9, orderIdCreated);
                psInsertProducts.addBatch();
            }
            psInsertProducts.executeBatch();

            conn.commit();
        } catch (Exception ex) {
            orderIdCreated = -1;
            try {
                if (savepoint != null) {
                    conn.rollback(savepoint);
                } else {
                    conn.rollback();
                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        } finally {
            try {
                if (psInsertOrderBill != null) {
                    psInsertOrderBill.close();
                }
                if (psInsertProducts != null) {
                    psInsertProducts.close();
                }
                conn.setAutoCommit(true);
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
        return orderIdCreated;
    }

    @Override
    public Product getProductByProductId(int productId) {
        Product retProduct = null;
        PreparedStatement psSelectProduct = null;
        String qSelectProduct = "SELECT * FROM product WHERE id = ?";
        ResultSet rsProduct = null;

        try {
            psSelectProduct = conn.prepareStatement(qSelectProduct);
            psSelectProduct.setInt(1, productId);
            rsProduct = psSelectProduct.executeQuery();
            if (rsProduct != null && rsProduct.next()) {
                retProduct = new Product();
                retProduct.setId(productId);
                retProduct.setColor(rsProduct.getString("color"));
                retProduct.setLinkSource(rsProduct.getString("link_source"));
                retProduct.setNotes(rsProduct.getString("notes"));
                retProduct.setPrice(rsProduct.getInt("price"));
                retProduct.setQuantity(rsProduct.getInt("quantity"));
                retProduct.setShopName(rsProduct.getString("shop_name"));
                retProduct.setSize(rsProduct.getString("size"));
                retProduct.setStatusId(rsProduct.getInt("status_id"));

            }
        } catch (Exception ex) {
            retProduct = null;
        } finally {
            if (psSelectProduct != null) {
                try {
                    psSelectProduct.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
            if (rsProduct != null) {
                try {
                    rsProduct.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
        }
        return retProduct;
    }
}
