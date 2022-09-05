package com.test.service.client;

import com.test.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User getUserById(int uid) {
        User user = new User();
        user.setName("我是替代方案");
        return user;
    }

    @Override
    public boolean userBorrow(int uid) {
        return false;
    }

    @Override
    public int userRemain(int uid) {
        return 0;
    }
}