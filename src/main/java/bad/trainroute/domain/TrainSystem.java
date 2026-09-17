package bad.trainroute.domain;

public class TrainSystem {

    public static String getRouteInfo(String s1, String s2) {
        return RouteSearcher.searchRoute(s1, s2);
    }

    public static String findAllRoutes(String from, String to) {
        String directRoute = RouteSearcher.searchRoute(from, to);

        if (!directRoute.equals("駅が見つかりません") && !directRoute.equals("不正なルートです")) {
            return directRoute;
        }

        String[] transferRoutes = TransferHandler.getRoutes(from, to);

        if (transferRoutes.length == 0) {
            return "ルートが見つかりません";
        }

        String result = "";
        for (int i = 0; i < transferRoutes.length; i++) {
            result = result + (i + 1) + ". " + transferRoutes[i] + "\n";
        }

        return result;
    }

    public static String getTimetableForStation(String station) {
        if (station.equals("新宿")) {
            String x = "新宿駅の時刻表:\n";
            x = x + "08:00 中央線吉祥寺行き\n";
            x = x + "08:15 中央線吉祥寺行き\n";
            x = x + "08:30 中央線吉祥寺行き\n";
            x = x + "08:45 中央線吉祥寺行き\n";
            return x;
        } else if (station.equals("中野")) {
            String y = "中野駅の時刻表:\n";
            y = y + "08:05 中央線吉祥寺行き\n";
            y = y + "08:20 中央線吉祥寺行き\n";
            y = y + "08:35 中央線吉祥寺行き\n";
            y = y + "08:50 中央線吉祥寺行き\n";
            return y;
        } else if (station.equals("吉祥寺")) {
            String z = "吉祥寺駅の時刻表:\n";
            z = z + "08:10 中央線新宿行き\n";
            z = z + "08:25 中央線新宿行き\n";
            z = z + "08:40 中央線新宿行き\n";
            z = z + "08:55 中央線新宿行き\n";
            return z;
        } else if (station.equals("品川")) {
            String timetable = "品川駅の時刻表:\n";
            timetable = timetable + "08:00 山手線上野行き\n";
            timetable = timetable + "08:10 山手線上野行き\n";
            timetable = timetable + "08:20 山手線上野行き\n";
            timetable = timetable + "08:30 山手線上野行き\n";
            return timetable;
        } else if (station.equals("東京")) {
            String t = "東京駅の時刻表:\n";
            t = t + "08:05 山手線新宿行き\n";
            t = t + "08:15 山手線新宿行き\n";
            t = t + "08:25 山手線新宿行き\n";
            t = t + "08:35 山手線新宿行き\n";
            return t;
        }
        return "不明な駅";
    }

    public static String showSchedule(String st) {
        if (st.equals("新宿")) {
            return "新宿駅の時刻表:\n08:00\n08:15\n08:30\n08:45";
        } else if (st.equals("中野")) {
            return "中野駅の時刻表:\n08:05\n08:20\n08:35\n08:50";
        } else if (st.equals("吉祥寺")) {
            return "吉祥寺駅の時刻表:\n08:10\n08:25\n08:40\n08:55";
        } else if (st.equals("品川")) {
            return "品川駅の時刻表:\n08:00\n08:10\n08:20\n08:30";
        } else if (st.equals("東京")) {
            return "東京駅の時刻表:\n08:05\n08:15\n08:25\n08:35";
        }
        return "駅なし";
    }

    public static boolean isValidStation(String station) {
        String[] validStations = {"新宿", "中野", "吉祥寺"};
        for (int i = 0; i < validStations.length; i++) {
            if (validStations[i].equals(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean stationExists(String s) {
        String d = "新宿,中野,吉祥寺";
        String[] arr = d.split(",");
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStation(String station) {
        if (station.equals("新宿") || station.equals("中野") || station.equals("吉祥寺") ||
            station.equals("品川") || station.equals("東京") || station.equals("上野")) {
            return true;
        }
        return false;
    }
}
