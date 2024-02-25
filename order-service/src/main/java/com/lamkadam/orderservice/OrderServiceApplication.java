package com.lamkadam.orderservice;

import com.lamkadam.orderservice.entities.Order;
import com.lamkadam.orderservice.entities.ProductItem;
import com.lamkadam.orderservice.enums.OrderState;
import com.lamkadam.orderservice.repository.OrderRepository;
import com.lamkadam.orderservice.repository.ProductItemRepository;
import com.lamkadam.orderservice.restclient.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			InventoryRestClient inventoryRestClient
	)
	{
		return  args -> {
			List<String> ProductsIds = List.of("P01", "P02" , "P03");

			for(int i=0 ; i<5 ; i++){
				Order order =Order.builder()
						.id(UUID.randomUUID().toString())
						.date(LocalDate.now())
						.state(OrderState.PENDING)
						.build();

				Order ordersaved= orderRepository.save(order);

				ProductsIds.forEach(pid->{
					ProductItem productItem =ProductItem.builder()
							.productId(pid)
							.quantity(new Random().nextInt(20))
							.price(Math.random()*6000+100)
							.order(ordersaved)
							.build();
					productItemRepository.save(productItem);
				});

			}
		};
	}

}
