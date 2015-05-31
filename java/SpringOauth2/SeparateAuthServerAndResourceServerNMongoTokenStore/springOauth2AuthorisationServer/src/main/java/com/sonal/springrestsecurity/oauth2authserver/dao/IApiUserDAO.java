package com.sonal.springrestsecurity.oauth2authserver.dao;

import com.sonal.springrestsecurity.oauth2authserver.bo.ApiUser;

public interface IApiUserDAO {

    ApiUser findApiUserByName(String userName);

}