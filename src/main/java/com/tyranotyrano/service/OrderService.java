package com.tyranotyrano.service;

import com.tyranotyrano.domain.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
