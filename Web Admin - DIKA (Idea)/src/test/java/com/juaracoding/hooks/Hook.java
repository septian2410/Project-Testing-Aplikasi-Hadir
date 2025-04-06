package com.juaracoding.hooks;

import com.juaracoding.drivers.DriverSingleton;

import com.juaracoding.drivers.utils.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Hook {

        @BeforeTest
        public static void init() {
            System.out.println("Initializing driver...");
            DriverSingleton.getDriver(BrowserType.CHROME);
        }

        @AfterTest
        public static void teardown() {
            System.out.println("Quitting driver...");
            DriverSingleton.quitDriver();
        }

//            @BeforeClass
//        public static void init() {
//            System.out.println("Initializing driver...");
//            DriverSingleton.getDriver(BrowserType.CHROME);
//        }
//
//        @AfterClass
//        public static void teardown() {
//            System.out.println("Quitting driver...");
//            DriverSingleton.quitDriver();
//        }
    }


















































