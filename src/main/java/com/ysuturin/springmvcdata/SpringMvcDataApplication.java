package com.ysuturin.springmvcdata;

import com.ysuturin.springmvcdata.services.IStatisticManipulationService;
import com.ysuturin.springmvcdata.services.StatisticManipulationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootApplication
public class SpringMvcDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMvcDataApplication.class, args);
		IStatisticManipulationService manipulationService = applicationContext.getBean(StatisticManipulationServiceImpl.class);
		String userDir= new File("src/main/resources/file.txt").getAbsolutePath();
		manipulationService.makeFileInvestigation(userDir);
	}

}
