/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.farmon.farmonclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farmon.farmondto.UserDTO;

/**
 *
 * @author sb
 */
public class FarmonClient {
    
    private WebTarget webTarget;
    private Client client;
    private String BASE_URI;
    
    public FarmonClient() {
        BASE_URI =  "http://localhost:8080/FarmonWebService/resources/";
    }
    public FarmonClient(String server,String serverPort) {
        BASE_URI =  "http://localhost:8080/FarmonWebService/resources/";
    }
    
    public UserDTO callLoginAuthService(UserDTO userDTO) {
        System.out.println("Hello World!");
        UserDTO loginDTO = new UserDTO();
        
        loginDTO.setUsername(userDTO.getUsername());
        loginDTO.setPassword(userDTO.getPassword());
//        String BASE_URI =  "http://localhost:8080/FarmonWebService/resources/";

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();

        webTarget = client.target(BASE_URI).path("allServices/loginAuth");
        WebTarget resource = webTarget;
        ObjectMapper objectMapper = new ObjectMapper();
        
        String dataDTOJSON;
        try {
            dataDTOJSON = objectMapper.writeValueAsString(loginDTO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            loginDTO.setResponseMsg("error");
//            dataDTOJSON = "";
            return loginDTO;
        }
        Invocation.Builder ib = resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON);
        Response response = ib.post(Entity.entity(dataDTOJSON, jakarta.ws.rs.core.MediaType.APPLICATION_JSON));
//        Response response = ib.get();
        String respMapJSON = response.readEntity(String.class);
        try {
            loginDTO = objectMapper.readValue(respMapJSON, UserDTO.class);
        } catch (IOException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            loginDTO.setResponseMsg("responserror");
            
        }
        return loginDTO;
//        System.out.println(firstDTO.getID());
//        System.out.println(firstDTO.getUsername());
//        System.out.println(firstDTO.getPassword());
//        System.out.println(firstDTO.getResponseMsg());
    }
}
