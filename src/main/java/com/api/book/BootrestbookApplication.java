package com.api.book;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) 
	{
		ApplicationContext ctx =  SpringApplication.run(BootrestbookApplication.class, args);
		
		BookRepositiory UsR = ctx.getBean(BookRepositiory.class);
		
		
		
		Book bk = new Book();
		bk.setTitle("thermodynamics");
		bk.setAuthor("P.K Nag");
		
		Book bsave = UsR.save(bk);
		
		System.out.println(bsave);
		
	}

}
