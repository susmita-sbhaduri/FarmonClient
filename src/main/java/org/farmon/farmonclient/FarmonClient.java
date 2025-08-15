/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.farmon.farmonclient;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.glassfish.jersey.jackson.JacksonFeature;
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

    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        UserDTO firstDTO = new UserDTO();
        firstDTO.setID("2");
        firstDTO.setUsername("susmita");
        firstDTO.setPassword("susmita");
        String BASE_URI =  "http://localhost:8080/FarmonWebService/resources/";

        Client client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();

        WebTarget webTarget = client.target(BASE_URI).path("loginAuth");
        WebTarget resource = webTarget;
        ObjectMapper objectMapper = new ObjectMapper();
        
        String dataDTOJSON;
        try {
            dataDTOJSON = objectMapper.writeValueAsString(firstDTO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
//            firstDTO.setResponseMsg("error");
            dataDTOJSON = "";
//            return firstDTO;
        }
        Invocation.Builder ib = resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON);
        Response response = ib.post(Entity.entity(dataDTOJSON, jakarta.ws.rs.core.MediaType.APPLICATION_JSON));
//        Response response = ib.get();
        String respMapJSON = response.readEntity(String.class);
        try {
            firstDTO = objectMapper.readValue(respMapJSON, UserDTO.class);
        } catch (IOException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
//            firstDTO.setCode("responserror");
//            return fractalDTO;
        }
        System.out.println(firstDTO.getID());
        System.out.println(firstDTO.getUsername());
        System.out.println(firstDTO.getPassword());
        System.out.println(firstDTO.getResponseMsg());
    }
    
    
}
