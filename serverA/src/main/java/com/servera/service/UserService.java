package com.servera.service;

import com.servera.controller.req.AddUseRequest;
import org.springframework.stereotype.Service;


public interface UserService {

    Integer addUser(AddUseRequest req);
}
