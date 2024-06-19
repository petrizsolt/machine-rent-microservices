package hu.machinerental.api_gateway_for_frontend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hu.machinerental.api_gateway_for_frontend.dto.KeycloakTokenResponse;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/auth")
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AuthController {
	private final RestTemplate restTemplate;
	
    @Value("${spring.security.oauth2.client.registration.keycloak.token-uri}")
    private String keycloackTokenUri;
    
    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String keycloackClientSecret;
    
    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String keycloackClientId;
    
    @Value("${spring.security.oauth2.client.registration.keycloak.authorization-grant-type}")
    private String keycloackAuthType;
    
    @GetMapping("/get-token")
    public KeycloakTokenResponse getToken(@RequestParam String username, 
    		@RequestParam String password) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        Map<String, String> params = new HashMap<>();
        params.put("grant_type", keycloackAuthType);
        params.put("client_id", keycloackClientId);
        params.put("client_secret", keycloackClientSecret);
        params.put("username", username);
        params.put("password", password);

        StringBuilder requestBody = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (requestBody.length() > 0) {
                requestBody.append("&");
            }
            requestBody.append(entry.getKey()).append("=").append(entry.getValue());
        }

        HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<KeycloakTokenResponse> response = restTemplate
        		.exchange(keycloackTokenUri, HttpMethod.POST, request, KeycloakTokenResponse.class);

        return response.getBody();
    }
}
