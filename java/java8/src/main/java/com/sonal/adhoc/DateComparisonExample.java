package com.sonal.adhoc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateComparisonExample {

    public static void main(String[] args) {

	/*List<DateRange> dateRanges = getDateRanges();
	
	for (DateRange dateRange : dateRanges) {
	    System.out.println(dateRange);
	}*/
	
	DateRange newDateRange1 = DateRange.getNewDateRange("03/11/2017", 7, 55, 7,15);
	DateRange newDateRange2 = DateRange.getNewDateRange("03/11/2017", 11, 20, 7,15);
	
	System.out.println(newDateRange1.getStartTime().compareTo(newDateRange2.getStartTime()));
	System.out.println(newDateRange1.getEndtime().compareTo(newDateRange2.getEndtime()));
	
	LocalDateTime localDatetime1 = DateUtil.convertToLocalDateTime(newDateRange1.getStartTime());
	LocalDateTime localDatetime2 = DateUtil.convertToLocalDateTime(newDateRange2.getStartTime());
	
	System.out.println(localDatetime1.compareTo(localDatetime2));
	
	
	
	
	
	
	int startHr = localDatetime1.getHour();
	System.out.println(startHr);
	int startMin = localDatetime1.getMinute();
	System.out.println(startMin);
	
	int totalStartMin = startHr * 60 + startMin;
	
	
	
	int endHr = localDatetime2.getHour();
	System.out.println(endHr);
	int endMin = localDatetime2.getMinute();
	System.out.println(endMin);
	
	int totalEndMin = endHr * 60 + endMin;
	
	System.out.println("-------------------------------------------------------------------------------------------------------------------");
	
	int diffTotalMin = totalEndMin - totalStartMin;
	
	int diffHr = diffTotalMin/60;
	int diffMin = diffTotalMin%60;
	
	System.out.println(diffHr + " hrs " + diffMin + " mins" );
	
	
	
	
    }

    public static List<DateRange> getDateRanges() {
	
	List<DateRange> dateRanges = new ArrayList<>();
	
	dateRanges.add(DateRange.getNewDateRange("03/11/2017", 6, 45, 07,15));
	dateRanges.add(DateRange.getNewDateRange("03/11/2017", 9, 5, 10,15));
	dateRanges.add(DateRange.getNewDateRange("03/11/2017",11 , 05, 12,15));
	dateRanges.add(DateRange.getNewDateRange("03/11/2017", 12, 15, 13,15));
	
	return dateRanges;
    }
}
