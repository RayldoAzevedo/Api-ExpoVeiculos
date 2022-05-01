package br.com.azevedo.rayldo.expo_veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.azevedo.rayldo.expo_veiculos.service.S3Service;

@SpringBootApplication
public class ExpoVeiculosApplication implements CommandLineRunner{
@Autowired
private S3Service s3Service;

public static void main(String[] args) {SpringApplication.run(ExpoVeiculosApplication.class, args);}

	@Override
	public void run(String... args) throws Exception{
		s3Service.uploadFile("C:\\Users\\rayld\\Downloads\\mav.jpg");
	}
}

