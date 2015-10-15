package vn.aliviet.order.biz;

import vn.aliviet.order.entity.User;

/**
 * Created by windluffy on 10/11/2015.
 */
public interface IUserInfoRepository {
    /***
     * get User is identified by her/his username
     * @param username
     * @return User is identified by her/his username
     */
    User getUserByUsername(String username);

    /***
     * get User is identified by her/his id
     * @param id
     * @return User is identified by her/his id
     */
    User getUserById(int id);
}
