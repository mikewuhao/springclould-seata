package com.servera.service;

import com.servera.controller.req.AddUseRequest;
import com.servera.controller.req.ModifyUseRequest;


public interface UserService {

    Integer addUser(AddUseRequest req);

    Integer modifyUser(ModifyUseRequest req);

    Integer deleteUser(Long id);


}
