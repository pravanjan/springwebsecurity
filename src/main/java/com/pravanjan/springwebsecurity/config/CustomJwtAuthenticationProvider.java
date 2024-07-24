package com.pravanjan.springwebsecurity.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.stereotype.Component;

@Component
public class CustomJwtAuthenticationProvider  implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = String.valueOf(authentication.getCredentials());

        try {
            if(token !=null || !token.isEmpty()) {
                BearerToken bearerToken =   new BearerToken(token); // BearerToken is a custom implementation of Authentication
                bearerToken.setAuthenticated(true);
                return bearerToken;
            }
            else {
                throw new BadCredentialsException("Invalid token inside else ");
            }

        } catch (Exception e) {
            throw new BadCredentialsException("Invalid token", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return BearerTokenAuthentication.class.isAssignableFrom(authentication);
    }
}
