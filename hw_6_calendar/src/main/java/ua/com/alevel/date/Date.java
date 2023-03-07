package ua.com.alevel.date;

public class Date {

    public Date(int dd, int mm, int yy) {
        this.day = dd;
        this.month = mm;
        this.year = yy;
    }

    private static final String[][] MONTHS = {{"january", "february", "march", "april", "may",
            "june", "july", "august", "september", "october", "november", "december"},
            {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"}};
    private static final int HOUR_IN_DAY = 24;
    private static final int HOUR_AND_SECOND_NUMBER = 24;
    private static final int MONTH_IN_YEAR = 12;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    private int sec;
    private int ms;

    /*public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(final int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(final int min) {
        this.min = min;
    }

    public int getSec() {
        return this.sec;
    }

    public void setSec(final int sec) {
        this.sec = sec;
    }

    public int getMs() {
        return this.ms;
    }

    public void setMs(final int ms) {
        this.ms = ms;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(final int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(final int month) {
        this.month = month;
    }
*/

    public static String differenceInDates(Date dateOne, Date dateTwo) {//пользователь дает дату месяц и год
        int bigYear = 0;
        int tempYear;
        int tempMonth;

        int differenceYear = Math.abs(dateOne.year - dateTwo.year);
        int differenceMonth = Math.abs(dateOne.month - dateTwo.month);
        int differenceDay = 0;

        if (differenceYear > 0) {
            tempYear = Math.min(dateOne.year, dateTwo.year);
            for (int i = 0; i <= differenceYear; i++) {
                if ((tempYear) % 4 == 0) {
                    bigYear++;
                }
                tempYear++;
            }

        }

        if (differenceMonth > 0) {
            tempMonth = Math.min(dateOne.month, dateTwo.year);
            for (int i = 0; i < differenceMonth; i++) {
                differenceDay = differenceDay + Integer.parseInt(MONTHS[1][tempMonth]);
                tempMonth++;
            }
        }
        differenceMonth = differenceMonth + (differenceYear * MONTH_IN_YEAR);
        differenceDay = differenceDay + bigYear;
        int temp=differenceMonth;
        while (temp > 12) {
            temp=temp-12;
            differenceDay=differenceDay+365;
        }
        for (int i=0;i<temp;i++){
            differenceDay=differenceDay+Integer.parseInt(MONTHS[1][i]);
        }

            return " Разница в годах: " + differenceYear + "\n" +
                    " Разница в месяцах: " + differenceMonth + "\n" +
                    " Разница в днях: " + differenceDay + "\n" +
                    " Разница в часах: " + differenceDay * HOUR_IN_DAY + "\n" +
                    " Разница в минутах: " + differenceDay * HOUR_IN_DAY * HOUR_AND_SECOND_NUMBER + "\n" +
                    " Разница в  секундах: " + differenceDay * HOUR_IN_DAY * HOUR_AND_SECOND_NUMBER * HOUR_AND_SECOND_NUMBER + "\n" +
                    " Разница в  в миллисекундах: " + 1000 * differenceDay * HOUR_IN_DAY * HOUR_AND_SECOND_NUMBER * HOUR_AND_SECOND_NUMBER;


        }
    }
