package vn.aliviet.order.biz;

import java.sql.Connection;

/**
 * Created by windluffy on 10/6/2015.
 */
abstract class DBBase {
    protected Connection conn;

    public DBBase(Connection conn) {
        this.conn = conn;
    }

    public DBBase() {
        this.conn = (new DBConnection()).getConnection();
    }
}
