package com.devwow.aula;

import com.devwow.entities.Order;
import com.devwow.services.OrderService;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.devwow"})
public class AulaApplication implements CommandLineRunner {

	@Autowired
	private OrderService OrderService;

	public static void main(String[] args) {

		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc =  new Scanner(System.in);

		/*Order employee = new Order("Maria", 4000.0);
		System.out.println(salaryService.netSalary(employee));*/
		System.out.println("Dados do pedido: ");
		System.out.println("Código: ");
		int codigo = sc.nextInt();
		System.out.println("Valor básico: ");
		double valor = sc.nextDouble();
		System.out.println("Porcentagem de desconto: ");
		double desconto = sc.nextDouble();

		Order order = new Order(codigo, valor, desconto);

		System.out.print("Pedido código ");
		System.out.println(codigo);
		System.out.print("Valor total: ");
		System.out.print(OrderService.total(order));


		sc.close();
	}
}
