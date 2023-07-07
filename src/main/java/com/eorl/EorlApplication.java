package com.eorl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EorlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EorlApplication.class, args);
		//build.gradle에 hibernate버전 확인을 위한 System.out
		//System.out.println("org.hibernate.Version.getVersionString() = " + org.hibernate.Version.getVersionString());
	}

}
