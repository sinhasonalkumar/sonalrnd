package com.sonal.adhoc;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames = true)
public class DateRange {

    private Date startTime;
    
    private Date endtime;
    
    
    public static DateRange getNewDateRange(String date, Integer startHr, Integer startMin, Integer endHr, Integer endMin ){
	
	Date startTime = DateUtil.createNewDateRange(date, startHr, startMin);
	Date endtime = DateUtil.createNewDateRange(date, endHr, endMin);
	
	DateRange dateRange = new DateRange();
	
	dateRange.setEndtime(endtime);
	dateRange.setStartTime(startTime);
	
	return dateRange;
	
    }
}
