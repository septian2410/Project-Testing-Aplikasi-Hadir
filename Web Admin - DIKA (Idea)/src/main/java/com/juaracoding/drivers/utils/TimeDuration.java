package com.juaracoding.drivers.utils;

public class TimeDuration {

    public static final int ONE = 1000; // 1 detik = 1000 ms
    public static final int TWO = 2000;
    public static final int THREE = 3000;
    public static final int FOUR = 4000;
    public static final int FIVE = 5000;


    // prevent instance
    private TimeDuration() {
        throw new UnsupportedOperationException("Class ini hanya boleh mengakses konstanta");
    }

}
