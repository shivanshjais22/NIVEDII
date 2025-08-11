package com.example;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.handler.TextWebSocketHandler;



@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final GPSHandler gpsHandler;

    public WebSocketConfig(GPSHandler gpsHandler) {
        this.gpsHandler = gpsHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocket endpoint: ws://localhost:8080/gps
        registry.addHandler(gpsHandler, "/gps").setAllowedOrigins("*");
    }
}