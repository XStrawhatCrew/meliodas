package vn.aliviet.order.biz;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by windluffy on 10/7/2015.
 */
public class DBOrderProductsRepositoryTest extends TestCase {
    Connection conn = null;
    DBOrderProductsRepository repository;
    public void setUp() throws Exception {
        super.setUp();
        conn = (new DBConnection()).getConnection();
        repository = new DBOrderProductsRepository(conn);
    }

    @Test
    public void createOrder_emptyListProduct_returnEmptyProductCode(){
        
    }
}