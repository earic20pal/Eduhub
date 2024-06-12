package com.eduhub.StudentManagement.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.eduhub.StudentManagement.Model.StudentProfile;


public class HelperUtil {

    private HelperUtil() {
    }


    public static Supplier<List<StudentProfile>> StudentProfileSupplier = () ->
            Arrays.asList(
            		StudentProfile.builder().studentProfileId(1).firstName("Binay").lastName("Gurung").salary(3000.0f).position("teacher").positionId(10).build(),
            		StudentProfile.builder().studentProfileId(10).firstName("Ajay").lastName("Devgan").salary(12000.0f).position("teacher").positionId(10).build()
            );


}
