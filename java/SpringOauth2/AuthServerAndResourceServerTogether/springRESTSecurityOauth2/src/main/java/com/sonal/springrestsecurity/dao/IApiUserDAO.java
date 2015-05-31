package com.sonal.springrestsecurity.dao;

import com.sonal.springrestsecurity.bo.ApiUser;

public interface IApiUserDAO {

    ApiUser findApiUserByName(String userName);

}