package com.servera.service;

import com.servera.controller.req.AddUserRequest;
import com.servera.controller.req.ModifyUserRequest;


public interface UserService {

    Integer addUser(AddUserRequest req);

    Integer modifyUser(ModifyUserRequest req);

    Integer deleteUser(Long id);


}
