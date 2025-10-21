package com.Leo.Project.config;

import com.Leo.Project.entities.*;
import com.Leo.Project.entities.enums.OrderStatus;
import com.Leo.Project.repositories.*;
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
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null,"Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null,"Computers");

        Product p1 = new Product(null,"the Lord of The Rigs", "Só compre, leia e descubra porque e um dos melhores livros que existem",90.5,"");
        Product p2 = new Product(null,"Smart TV", "TV inteligente 4k",2190.0,"");
        Product p3 = new Product(null,"Macbook Pro", "O sistema e fraco vai de linux",1250.0,"");
        Product p4 = new Product(null,"Pc Gamer", "Roda tudo seja feliz",1200.0,"");
        Product p5 = new Product(null,"Rails for Dummies", "Se quer aprender sobre trilhos esse e o livro",100.99,"");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User("Maria Brown", "Maria@gmail.com","219665874","123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "219887463","123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null,Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null,Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT,u1);


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
        OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
        OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
        OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

    }
}
