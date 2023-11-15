package com.app.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.ms.orders.entity.Order;
import com.app.ms.orders.repository.OrderRepository;
import com.app.ms.security.entity.User;
import com.app.ms.security.repository.UserRepository;


@Service
public class UserOrdersService {

	@Autowired
	private OrderRepository orderRepository; 
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(transactionManager = "securityTransactionManager")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	
	@Transactional(transactionManager = "ordersTransactionManager")
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
}
