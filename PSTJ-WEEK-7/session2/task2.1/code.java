import java.util.*;

class UndergroundSystem {

    // Stores customer ID -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkIns;

    // Stores route -> [totalTime, numberOfTrips]
    private Map<String, double[]> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);

        String route = data.stationName + "->" + stationName;
        double travelTime = t - data.time;

        if (!routes.containsKey(route)) {
            routes.put(route, new double[]{0, 0});
        }

        routes.get(route)[0] += travelTime;
        routes.get(route)[1]++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;

        double[] data = routes.get(route);

        return data[0] / data[1];
    }

    // Helper class to store check-in information
    static class CheckInData {
        String stationName;
        int time;

        CheckInData(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
}
