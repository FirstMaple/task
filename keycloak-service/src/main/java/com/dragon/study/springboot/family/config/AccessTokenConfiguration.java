package com.dragon.study.springboot.family.config;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by dragon on 16/6/19.
 */
@Configuration
public class AccessTokenConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public AccessToken getAccessToken() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    return ((KeycloakPrincipal) request.getUserPrincipal()).getKeycloakSecurityContext().getToken();
  }
}
