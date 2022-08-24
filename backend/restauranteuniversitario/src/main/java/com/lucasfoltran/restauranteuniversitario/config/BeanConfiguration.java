package com.lucasfoltran.restauranteuniversitario.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfiguration {
  
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public CommonsRequestLoggingFilter logFilter() {
      CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
      filter.setIncludeQueryString(true);
      filter.setIncludePayload(true);
      filter.setMaxPayloadLength(10000);
      filter.setIncludeHeaders(false);
      filter.setAfterMessagePrefix("REQUEST DATA : ");
      return filter;
  }

}
