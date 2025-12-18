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
//        BASE_URI =  "http://103.211.202.129:8080/FarmonWebService/resources/";
    }
    public FarmonClient(String server,String serverPort) {
        BASE_URI =  "http://localhost:8080/FarmonWebService/resources/";
//        BASE_URI =  "http://103.211.202.129:8080/FarmonWebService/resources/";
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
    
    public FarmonDTO callEditHarvRecService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editHarvestRec");
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
    
    public FarmonDTO callResCropPerResService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropPerRes");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResCropPerResDtService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropPerResDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResCropSumHarDtService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropSumHarDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResCropPerHarDtService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropPerHarDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callLabCropSumHarDtService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/labCropSumHarDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callLabCropDtlsHarDtService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/labCropDtlsHarDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpExpPerDtService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empExpensePerDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEditEmpExpService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editEmpExp");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxEmpExpIdService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxEmpExpId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddEmpExpService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addEmpExp");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callActiveEmpExpService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/activeEmpExp");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpLeaveCountService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empLeaves");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxLeaveIdService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxEmpLeave");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddEmpLeaveService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addEmpLeave");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callGetEmpLeavesService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empLeaveList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpActiveLoanService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empActiveLoans");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpPaidLoanService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empPaidLoans");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpPaybkLoanService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empPaybkPerLoan");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEmpNameforIdService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/empNameForId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxEmpIdService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxEmpId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callGetActiveEmpService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/getActiveEmp");
        return callFarmonService(farmondto);
    }
    
//    public FarmonDTO callGetEmpNamePerIdService(FarmonDTO farmondto) {
//        client = ClientBuilder.newBuilder()
//                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
//                   .build();
//        webTarget = client.target(BASE_URI).path("allServices/empNameforId");
//        return callFarmonService(farmondto);
//    }
    
    public FarmonDTO callAddEmpService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addEmployee");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEditEmpService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editEmployee");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMonthlyExpRptService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resCropExpMonthly");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callRecAcqRptService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resAcqReport");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxRescropIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxResCropId");
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
    
    public FarmonDTO callNonzeroresListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/nonzeroresList");
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
    
    public FarmonDTO callResnameForIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resnameForId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callShopResListService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/shopresList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callNonZeroStockShopResService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/nonzeroStockList");
        return callFarmonService(farmondto);
    }  
    
    public FarmonDTO callDistictShopResService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/distictShopRes");
        return callFarmonService(farmondto);
    }  
    
    public FarmonDTO callAddFarmresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addFarmresource");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEditFarmresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editFarmresource");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxShopResIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxShopresId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxResAcqIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxResAcqId");
        return callFarmonService(farmondto);
    }    
    
    public FarmonDTO callMaxExpIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxExpId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxLabcropIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxLabcropId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddLabcropService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addLabcrop");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelLabcropService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delLabcrop");
        return callFarmonService(farmondto);
    }
    public FarmonDTO callAddShopresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addShopRes");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEditShopresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editShopRes");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelShopresService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delShopResid");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddResacqService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addResAcq");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelResAcqService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delResAcq");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callResacqPerResService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/resAcqResid");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDisResacqPerResService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/disResAcqResid");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddExpService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addExpense");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelExpService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delExpense");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelFarmresService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delFarmresource");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callShopResForResidService(FarmonDTO farmondto) {
        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/shopresPerResid");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callTaskplanListService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/taskplanList");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callTaskLstBtnDatesService(FarmonDTO farmondto) {
//        System.out.println("Hello World!");

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/taskLstBtnDt");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callMaxTaskplanIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/maxTaskplanId");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callAddTaskplanService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addTaskplan");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callEditTaskplanService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/editTaskplan");
        return callFarmonService(farmondto);
    }
    public FarmonDTO callDeleteTaskplanService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/deleteTaskplan");
        return callFarmonService(farmondto);
    }
    public FarmonDTO callAddResCropService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/addRescrop");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callDelResCropService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/delRescrop");
        return callFarmonService(farmondto);
    }
    
    public FarmonDTO callTaskplanIdService(FarmonDTO farmondto) {

        client = ClientBuilder.newBuilder()
                   .register(org.glassfish.jersey.jackson.JacksonFeature.class)
                   .build();
        webTarget = client.target(BASE_URI).path("allServices/taskplanPerId");
        return callFarmonService(farmondto);
    }
    
    
}
