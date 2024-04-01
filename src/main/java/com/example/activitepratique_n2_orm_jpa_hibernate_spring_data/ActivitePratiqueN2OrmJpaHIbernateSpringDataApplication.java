package com.example.activitepratique_n2_orm_jpa_hibernate_spring_data;

import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.entities.Medecin;
import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.entities.Patient;
import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.entities.Product;
import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.repository.MedecinRepository;
import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.repository.PatientRepository;
import com.example.activitepratique_n2_orm_jpa_hibernate_spring_data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ActivitePratiqueN2OrmJpaHIbernateSpringDataApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(ActivitePratiqueN2OrmJpaHIbernateSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "Computer",5000,4));
		productRepository.save(new Product(null, "Smart Phone",8000,26));
		productRepository.save(new Product(null, "Pinter",2000,12));
		List<Product> products = productRepository.findAll();
		products.forEach(p->{
			System.out.println(p.toString());
		});
		Product product=productRepository.findById(Long.valueOf(2)).get();
		System.out.println("***************************************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println("***************************************");

		System.out.println("********* Methode Search (FindByNameConatins) *********");
		List<Product> productList=productRepository.findByNameContains("C");
		productList.forEach(p->{
			System.out.println(p);
		});

		System.out.println("********* Methode Search (Query) *********");
		List<Product> productListSearch=productRepository.search("%C%");
		productListSearch.forEach(p->{
			System.out.println(p);
		});
	}
	@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository){
		return args -> {
			Stream.of("Mohammed","Aya","Nour").forEach(name->{
				Patient patient=new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(true);
				patientRepository.save(patient);
			});
			Stream.of("Aya","Yahya","Nour").forEach(name->{
				Medecin medecin=new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				medecinRepository.save(medecin);
			});

		};
	}
}
