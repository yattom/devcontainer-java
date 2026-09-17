package bad.trainroute.domain;

public class DataStore {
    public static String[][] lineData = {
        {"中央線", "新宿,中野,吉祥寺,東京"},
        {"山手線", "新宿,上野,東京,品川"}
    };

    public static String getStationList(String lineName) {
        for (int i = 0; i < lineData.length; i++) {
            if (lineData[i][0].equals(lineName)) {
                return lineData[i][1];
            }
        }
        return "";
    }

    public static String[] getAllLines() {
        String[] lines = new String[lineData.length];
        for (int i = 0; i < lineData.length; i++) {
            lines[i] = lineData[i][0];
        }
        return lines;
    }

    public static String getLineForStation(String station) {
        for (int i = 0; i < lineData.length; i++) {
            String stations = lineData[i][1];
            if (stations.contains(station)) {
                return lineData[i][0];
            }
        }
        return null;
    }

    public static boolean isStationOnLine(String station, String line) {
        String stationList = getStationList(line);
        return stationList.contains(station);
    }
}
