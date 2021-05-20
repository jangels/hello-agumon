package org.smallfire.java.proxy;

public class UserDAO implements AbstractUserDAO {
    @Override
    public Boolean findUserById(String userId) {
        System.out.println("findUserById" + userId);
        return true;
    }
}
