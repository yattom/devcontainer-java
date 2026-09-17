package bad.trainroute.domain;

public class RouteSearcher {

    public static String searchRoute(String from, String to) {
        String lineName = "中央線";

        String stStr = DataStore.getStationList(lineName);
        String[] stations = stStr.split(",");

        int a = -1;
        int b = -1;

        for (int i = 0; i < stations.length; i++) {
            if (stations[i].equals(from)) {
                a = i;
            }
            if (stations[i].equals(to)) {
                b = i;
            }
        }

        if (a == -1 || b == -1) {
            return "駅が見つかりません";
        }

        if (a >= b) {
            return "不正なルートです";
        }

        String result = from + "で" + lineName + "に乗車して、" + to + "で下車します。";

        return result;
    }

    public static String findRoute(String departure, String arrival) {
        String line = "中央線";

        String sStr = DataStore.getStationList(line);
        String[] stationArray = sStr.split(",");

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < stationArray.length; i++) {
            if (stationArray[i].equals(departure)) {
                idx1 = i;
            }
            if (stationArray[i].equals(arrival)) {
                idx2 = i;
            }
        }

        if (idx1 == -1 || idx2 == -1) {
            return "駅が見つかりません";
        }

        if (idx1 >= idx2) {
            return "不正なルートです";
        }

        String ans = departure + "で" + line + "に乗車して、" + arrival + "で下車します。";

        return ans;
    }
}
