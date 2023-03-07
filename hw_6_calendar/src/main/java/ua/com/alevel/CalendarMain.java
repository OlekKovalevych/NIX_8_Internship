package ua.com.alevel;


import ua.com.alevel.date.Date;

public class CalendarMain {
    public static void main(String[] args) {

        Date date=new Date(17,8,2020);
        Date date1=new Date(18,9,2021);

        System.out.println(Date.differenceInDates(date1,date));

    }
}
