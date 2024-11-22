package com.devsuperior.di;

import com.devsuperior.di.entities.Order;
import com.devsuperior.di.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(DiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Datos del pedido: código, valor básico, porcentaje de descuento)");
        System.out.print("Codigo: ");
        int code = in.nextInt();
        System.out.print("Valor basico: ");
        double valorBasico = in.nextDouble();
        System.out.print("Porcentaje de descuento: ");
        double porcentajeDeDescuento = in.nextDouble();

        Order order = new Order(code, valorBasico, porcentajeDeDescuento);

        System.out.println("Pedido codigo " + order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
    }
}
