package com.example.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ MessageConfiguration.class })
public class AppConfig
{

	// Put Any Other Application configuration here.
}

