package com.example.demo.database;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Bean
    CommandLineRunner initDatabase(ProductRepos productRepos){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product1 = new Product("iphone 13 promax",2021,2500,"");
                Product product2 = new Product("iphone 12 promax",2020,1500,"");
                System.out.println("insert data: "+productRepos.save(product1));
                System.out.println("insert data: "+productRepos.save(product2));
            }
        };
    }
}
