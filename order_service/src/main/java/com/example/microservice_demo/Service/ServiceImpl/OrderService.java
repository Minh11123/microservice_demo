package com.example.microservice_demo.Service.ServiceImpl;

import com.example.microservice_demo.Controller.GetInforUser;
import com.example.microservice_demo.Controller.Reponse.UserResponse;
import com.example.microservice_demo.Controller.Request.CreateOrderRequest;
import com.example.microservice_demo.Model.Order;
import com.example.microservice_demo.Repository.OrderRepo;
import com.example.microservice_demo.Repository.ProductRepo;
import com.example.microservice_demo.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private GetInforUser getInforUser;
    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order create(CreateOrderRequest createOrderRequest) {
        UserResponse userResponse = getInforUser.getInfor(createOrderRequest.getCustomerId()).getBody();
        Order order = new Order();
        order.setOrderStatus("new");
        order.setCreationDate(new Date());
        order.setCustomerId(userResponse.getId());
        order.setAddress(createOrderRequest.getAddress());
        order.setCustomerPhoneNumber(userResponse.getPhoneNumber());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3); // Thêm 3 ngày vào thời gian hiện tại
        order.setEstimatedTeliveryTime(calendar.getTime());
        order.setPaymentStatus("Chua thanh toan!");

        List<Long> ids = new ArrayList<>();
        for (Long id:
             createOrderRequest.getProductsId()) {
            ids.add(id);
        }
        order.setProducts(productRepo.findAllById(ids));
        orderRepo.save(order);
        return order;
    }


}
