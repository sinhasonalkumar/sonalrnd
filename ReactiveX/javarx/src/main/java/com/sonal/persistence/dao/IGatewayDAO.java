package com.sonal.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sonal.persistence.bo.GatewayBO;

public interface IGatewayDAO extends MongoRepository<GatewayBO, Serializable> {

    List<GatewayBO> findByCustomerId(String customerId);
}
