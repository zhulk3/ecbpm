package com.ecbpm.service;

import com.ecbpm.pojo.OrderDetail;
import com.ecbpm.pojo.OrderInfo;
import com.ecbpm.pojo.Pager;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager);

    Integer count(Map<String,Object>params);

    int addOrderInfo(OrderInfo orderInfo);

    int addOrderDetail(OrderDetail orderDetail);

    OrderInfo getOrderInfoById(int id);

    List<OrderDetail> getOrderDetailByOid(int oid);

    int deleteOrder(int id);
}
