package com.company.framework.utils;

import com.company.framework.constants.ClientCons;
import com.company.framework.constants.OutOfStockCons;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;


public class APIUtils {

    public static int markItemAsOOS(String item){
        String baseURI = getOutOfStockBaseURI(item, "item");
        return OutOfStockAPIExecutor(baseURI, "true");
    }


    public static int markItemAsInStock(String item){
        String baseURI = getOutOfStockBaseURI(item, "item");
        return OutOfStockAPIExecutor(baseURI, "false");
    }


    public static int markModifierAsOOS(String modifier){
        String baseURI = getOutOfStockBaseURI(modifier, "modifier");
        return OutOfStockAPIExecutor(baseURI, "true");
    }


    public static int markModifierAsInStock(String modifier){
        String baseURI = getOutOfStockBaseURI(modifier, "modifier");
        return OutOfStockAPIExecutor(baseURI, "false");
    }


    /* Create the Out of Stock API URL. It receives the element to change the status and its type (item or modifier) */
    private static String getOutOfStockBaseURI(String element, String OOSType) {
        String baseURI = "";

        switch (ClientCons.CURRENT_PARNER){
            case "iOS":
                baseURI = OutOfStockCons.E_API_URL+ OutOfStockCons.E_STORE;
                break;
            case "R":
                baseURI = OutOfStockCons.R_API_URL+ OutOfStockCons.R_STORE;
                break;
            case "W":
                baseURI = OutOfStockCons.W_API_URL+ OutOfStockCons.W_STORE;
                break;
            case "D":
                baseURI = OutOfStockCons.D_API_URL+ OutOfStockCons.D_STORE;
                break;
        }

        if(OOSType.equals("item"))
            baseURI = baseURI+"/item_stocks/"+ OutOfStockCons.getItemID(element);
        else if(OOSType.equals("modifier"))
            baseURI = baseURI+"/modifier_stocks/"+ OutOfStockCons.getModifierID(element);

        return baseURI;
    }


    /* Get the Auth Token based on the current Partner */
    private static String getAuthToken(){
        String token = "";

        switch (ClientCons.CURRENT_PARNER){
            case "iOS":
                token = "";
                break;
            case "R":
                token = "";
                break;
            case "W":
                token = "";
                break;
            case "D":
                token = "";
                break;
        }

        return token;
    }


    /* Out of Stock API executor */
    private static int OutOfStockAPIExecutor(String baseURI, String value) {

        RestAssured.baseURI = baseURI;

        Map<String, String> bodyTrue = new HashMap<>();
        bodyTrue.put("out_of_stock", value);

        RequestSpecification httpRequest = RestAssured.given()
                .header("content-type", "application/json; charset=utf-8")
                .header("x-request-id", "x-request-id")
                .header("x-authtoken", getAuthToken())
                .body(bodyTrue);

        Response response = httpRequest.put();

        return response.statusCode();

    }


}
