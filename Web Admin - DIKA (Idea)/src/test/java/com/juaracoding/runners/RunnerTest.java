package com.juaracoding.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {
                "src/test/resources/features/Web Admin/Menu 1 (Autentication Login)/LoginAdmin.feature",

                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 1/1ShiftingSearch.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 1/2ShiftingReset.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 1/3ShiftingEdit.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 1/4ShiftingDelete.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 1/5ShiftingTambahkan.feature",

                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 2/1JadwalSearch.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 2/2JadwalReset.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 2/3JadwalEdit.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 2/4JadwalDelete.feature",
                        "src/test/resources/features/Web Admin/Menu 2 (Management)/Sub Menu 2/5JadwalTambahkan.feature",

                "src/test/resources/features/Web Admin/Menu 3 (Autentication Logout)/LogoutAdmin.feature",

                "src/test/resources/features/Web User/LoginUser.feature",
                "src/test/resources/features/Web User/LogoutUser.feature",


        },
        glue = {
                "com.juaracoding.hooks",
                "com.juaracoding.WebAdmin.steps.authentication",
                "com.juaracoding.WebAdmin.steps.shifting",
                "com.juaracoding.WebAdmin.steps.jadwal",
                "com.juaracoding.WebUser.steps",
        },
        plugin = {
                "pretty",
                "html:target/cucumbers/reports.html",
                "json:target/cucumbers/reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }
)


public class RunnerTest extends AbstractTestNGCucumberTests {
}
