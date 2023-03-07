package ua.com.alevel.road_cost;

import ua.com.alevel.utils.MyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class RoadCost {

    private static final String READ_FILE_NAME = "input_road_cost.txt";
    private static final String WRITE_FILE_NAME = "output_road_cost.txt";
    private static final int INFINITE = Integer.MAX_VALUE;
    private static final int NUMBER_OF_CITIES = 10000;
    private static final int NUMBER_OF_PATHS_TO_FIND = 100;
    private static int countOfCities;

    private RoadCost() {
    }

    public static void run() throws IOException {
        List<String> readStringFile = MyUtils.readFileLine(RoadCost.READ_FILE_NAME);
        List<Integer> result = new ArrayList<>();
        StringBuilder builderResultLine = new StringBuilder();
        int readingLine = 1;
        try {
            RoadCost.countOfCities = Integer.parseInt(readStringFile.get(0));
            if (RoadCost.NUMBER_OF_CITIES < RoadCost.countOfCities) {
                return;
            }
            int[][] graph = new int[RoadCost.countOfCities][RoadCost.countOfCities];
            List<String> cities = new ArrayList<>();
            for (int i = 0; i < countOfCities; i++) {
                cities.add(readStringFile.get(readingLine++));
                int numOfNeighbours = Integer.parseInt(readStringFile.get(readingLine++));
                for (int j = 0; j < numOfNeighbours; j++) {
                    String[] neighbours = readStringFile.get(readingLine++).split(" ");
                    int cost = Integer.parseInt(neighbours[1]);
                    if (cost > 200000) {
                        return;
                    } else {
                        graph[i][Integer.parseInt(neighbours[0]) - 1] = cost;
                    }
                }
            }
            if (cities.size() != RoadCost.countOfCities) {
                return;
            }
            for (int i = 0; i < RoadCost.countOfCities; i++) {
                for (int j = 0; j < RoadCost.countOfCities; j++) {
                    if (graph[i][j] == 0) graph[i][j] = RoadCost.INFINITE;
                }
            }
            for (int i = 0; i < RoadCost.countOfCities; i++) {
                for (int j = 0; j < RoadCost.countOfCities; j++) {
                    if (graph[i][j] != graph[j][i])
                        return;
                }
            }
            int waysToFind = Integer.parseInt(readStringFile.get(readingLine++));
            if (RoadCost.NUMBER_OF_PATHS_TO_FIND < waysToFind)
                return;

            for (int i = 0; i < waysToFind; i++) {
                String[] paths = readStringFile.get(readingLine++).split(" ");
                int startPoint, endPoint;
                startPoint = cities.indexOf(paths[0]);
                endPoint = cities.indexOf(paths[1]);
                boolean[] visited = new boolean[countOfCities];
                result.add(RoadCost.findMinimalCost(startPoint, endPoint, visited, graph));
                if (result.get(result.size() - 1) == INFINITE) {
                    builderResultLine.append("The end and start points are not connected\n");
                } else {
                    builderResultLine.append(result.get(result.size() - 1)).append("\n");
                }
            }
            if (result.size() != waysToFind) {
                return;
            }

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            builderResultLine = new StringBuilder("Invalid input data, write as in example");
        } finally {
            readStringFile.clear();
            readStringFile.add(builderResultLine.toString());
            MyUtils.writeInFile(WRITE_FILE_NAME, readStringFile);
        }
    }

    private static int findMinimalCost(int startPoint, int endPoint, boolean[] visited, int[][] graph) {
        if (startPoint == endPoint) {
            return 0;
        }
        visited[startPoint] = true;
        int cost = RoadCost.INFINITE;
        for (int i = 0; i < RoadCost.countOfCities; i++) {
            if (RoadCost.INFINITE != graph[startPoint][i] && !visited[i]) {
                int current = RoadCost.findMinimalCost(i, endPoint, visited, graph);
                if (RoadCost.INFINITE > current) {
                    cost = Math.min(cost, graph[startPoint][i] + current);
                }
            }
        }
        visited[startPoint] = false;
        return cost;
    }
}

