package br.com.alura.challengebackend.infra;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfigurations {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
