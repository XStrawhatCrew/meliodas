package vn.aliviet.order.biz;

import vn.aliviet.order.entity.User;
import vn.aliviet.order.exception.CreateOrderException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by windluffy on 10/11/2015.
 */
public class DBUserInfoRepository extends DBBase implements IUserInfoRepository {

    public DBUserInfoRepository(Connection conn) {
        super(conn);
    }

    @Override
    public User getUserByUsername(String username) {
        User retUser = null;
        PreparedStatement psSelectUser = null;
        String qSelectUser = "SELECT * FROM user WHERE username = ?";
        ResultSet rsSelectUser = null;

        try {
            psSelectUser = conn.prepareStatement(qSelectUser);
            psSelectUser.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(psSelectUser != null) {
            try {
                rsSelectUser = psSelectUser.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rsSelectUser != null) {
            if(rsSelectUser.next()) {

            }
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
