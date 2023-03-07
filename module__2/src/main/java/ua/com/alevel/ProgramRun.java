package ua.com.alevel;

import ua.com.alevel.first_unique_name.FirstUniqueName;
import ua.com.alevel.list_of_dates.ListOfDates;
import ua.com.alevel.road_cost.RoadCost;

import java.io.IOException;

public class ProgramRun {

    public static void run() {
        try {
            ListOfDates.run();
            RoadCost.run();
            FirstUniqueName.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
