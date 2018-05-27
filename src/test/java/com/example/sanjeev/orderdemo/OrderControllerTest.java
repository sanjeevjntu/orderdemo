package com.example.sanjeev.orderdemo;

import com.example.sanjeev.orderdemo.controller.OrderController;
import com.example.sanjeev.orderdemo.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController classUnderTest;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testController() {


    }
}
