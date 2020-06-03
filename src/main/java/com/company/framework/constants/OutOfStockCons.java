package com.company.framework.constants;

public class OutOfStockCons {

    /* Partners API URLs */
    public static final String E_API_URL = "";
    public static final String W_API_URL = "";
    public static final String R_API_URL = "";
    public static final String D_API_URL = "";

    /* Partners default stores */
    public static final String E_STORE = "";
    public static final String R_STORE = "";
    public static final String W_STORE = "";
    public static final String D_STORE = "";


    /* ROTI items and modifiers*/
    public static final String SIGNATURE_RICE_PLATE = "505e5ca7-98f2-495c-9b76-1bb4128a86d8";

    public static final String PITA = "be0e9999-6fc6-422f-9973-9bb5f5be898d";


    /* Return Item ID */
    public static String getItemID(String item) {
        String itemId = "";

        switch (item) {
            case "Signature Rice Plate":
                itemId = SIGNATURE_RICE_PLATE;
        }

        return itemId;
    }

    /* Return Item ID */
    public static String getModifierID(String modifier) {
        String modifierId = "";

        switch (modifier) {
            case "Pita":
                modifierId = PITA;
        }

        return modifierId;
    }

}
