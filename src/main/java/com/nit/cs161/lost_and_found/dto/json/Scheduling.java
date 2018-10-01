package com.nit.cs161.lost_and_found.dto.json;

import java.sql.Timestamp;

/**
 * Description: 用于配送计划json<p>
 *
 * @Package: com.nit.cs161.lost_and_found.dto.json
 * @author: SailHe
 * @date: 2018/8/4 18:36
 */
public class Scheduling {
    private Integer intervalDay;
    private Timestamp startDate;
    private Timestamp endDate;

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
