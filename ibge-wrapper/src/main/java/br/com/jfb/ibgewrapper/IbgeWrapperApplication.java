package br.com.jfb.ibgewrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IbgeWrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbgeWrapperApplication.class, args);
	}

}
