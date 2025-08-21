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
import org.farmon.farmondto.FarmonDTO;
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
    private FarmonDTO callFarmonService(FarmonDTO farmonDTO) {
        WebTarget resource = webTarget;
        ObjectMapper objectMapper = new ObjectMapper();
        
        String dataDTOJSON;
        try {
            dataDTOJSON = objectMapper.writeValueAsString(farmonDTO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            farmonDTO.getUserDto().setResponseMsg("writejsonerror");
//            dataDTOJSON = "";
            return farmonDTO;
        }
        Invocation.Builder ib = resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON);
        Response response = ib.post(Entity.entity(dataDTOJSON, jakarta.ws.rs.core.MediaType.APPLICATION_JSON));
//        Response response = ib.get();
        String respMapJSON = response.readEntity(String.class);
        try {
            farmonDTO = objectMapper.readValue(respMapJSON, FarmonDTO.class);
        } catch (IOException ex) {
            Logger.getLogger(UserDTO.class.getName()).log(Level.SEVERE, null, ex);
            farmonDTO.getUserDto().setResponseMsg("responsreaderror");
            
        }
        return farmonDTO;
    }
    public FarmonDTO callLoginAuthService(FarmonDTO userDTO) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/loginAuth");
        return callFarmonService(userDTO);
    }
    
    public FarmonDTO callActiveHarvestListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/actiHarvestList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callHarvestRecService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/harvestRecord");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResCropListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callLabCropListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/labCropList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callFarmresListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/farmresourceList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxFarmresIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxFarmresourceId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callShopListService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/shopList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResidForNameService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/residForName");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callShopResListService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/shopresList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddFarmresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addFarmresource");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxShopResIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxShopresId");
        return callFarmonService(farmondto);
    }
}
