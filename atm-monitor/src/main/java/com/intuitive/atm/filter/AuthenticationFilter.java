package com.intuitive.atm.filter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.intuitive.atm.dto.BaseResponse;
import com.intuitive.atm.exception.InvalidTokenException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {
	
	private final Gson gson;

	private static final String SHOULD_NOT_FILTER = null;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// token verification base on header token

		log.info("Successfully authenticated user");
	
		  String authKey = request.getHeader("Authentication");

	        try {
	            if (StringUtils.isBlank(authKey)) {
	                throw new InvalidTokenException("Empty auth key");
	            }
	            
	            boolean isValidated = true; // we will validated the auth token here

	            if (StringUtils.isNotBlank(authKey) && !isValidated) {
	                throw new InvalidTokenException("Invalid Auth Key");
	            }
	            filterChain.doFilter(request, response);
	        } catch (InvalidTokenException e) {
	            log.error("Error Occurred with message: {}", e.getMessage());
	            response.getWriter().write(gson.toJson(BaseResponse.builder().error(e.getMessage()).httpStatus(HttpStatus.UNAUTHORIZED).build()));
	            response.setStatus(401);
	        }
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	    return Boolean.TRUE.equals(request.getAttribute(SHOULD_NOT_FILTER));
	}

}
