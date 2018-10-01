package com.nit.cs161.lost_and_found.constant.general;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Created by NR on 2017/10/21.
 */

public final class ProjectConstants {

    public final static Boolean SUCCESS = true;
    public final static Boolean FAILURE = false;
    public final static long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    public final static SimpleDateFormat ORDER_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public final static BigDecimal PRICE_EPS = new BigDecimal(0.001);
}
