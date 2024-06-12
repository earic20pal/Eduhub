package com.example.MongoDBConnection.Model;


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;



public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<DocumentNew>> StudentProfileSupplier = () ->
            Arrays.asList(
            		DocumentNew.builder().name("Binay").city("Gurung").age(20).build(),
            		DocumentNew.builder().name("Binay").city("Gurung").age(20).build()
            );


}
