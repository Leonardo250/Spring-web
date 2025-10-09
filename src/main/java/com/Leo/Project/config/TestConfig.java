package com.Leo.Project.config;

import com.Leo.Project.entities.Category;
import com.Leo.Project.entities.Order;
import com.Leo.Project.entities.User;
import com.Leo.Project.entities.enums.OrderStatus;
import com.Leo.Project.repositories.CategoryRepository;
import com.Leo.Project.repositories.OrderRepository;
import com.Leo.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null,"Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null,"Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        User u1 = new User("Maria Brown", "Maria@gmail.com","219665874","123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "219887463","123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null,Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null,Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT,u1);


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
