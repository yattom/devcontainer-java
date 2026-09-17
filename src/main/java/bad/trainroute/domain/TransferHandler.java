package bad.trainroute.domain;

public class TransferHandler {

    public static String[] findTransferStations(String from, String to) {
        String[] result = new String[10];
        int count = 0;

        String[] lines = DataStore.getAllLines();

        for (int i = 0; i < lines.length; i++) {
            if (DataStore.isStationOnLine(from, lines[i])) {
                for (int j = 0; j < lines.length; j++) {
                    if (!lines[i].equals(lines[j]) && DataStore.isStationOnLine(to, lines[j])) {
                        String stationsOnLineI = DataStore.getStationList(lines[i]);
                        String[] stArray = stationsOnLineI.split(",");

                        for (int k = 0; k < stArray.length; k++) {
                            if (DataStore.isStationOnLine(stArray[k], lines[j])) {
                                if (count < result.length) {
                                    result[count] = stArray[k];
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }

        String[] finalResult = new String[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public static String buildRoute(String from, String via, String to) {
        String line1 = DataStore.getLineForStation(from);
        String line2 = DataStore.getLineForStation(to);

        if (line1 == null || line2 == null) {
            return "ルートが見つかりません";
        }

        String route1 = from + "で" + line1 + "に乗車して、" + via + "で下車します。";
        String route2 = via + "で" + line2 + "に乗車して、" + to + "で下車します。";

        return route1 + " " + route2;
    }

    public static String[] getRoutes(String start, String end) {
        String[] transfers = findTransferStations(start, end);
        String[] routes = new String[transfers.length];

        for (int i = 0; i < transfers.length; i++) {
            routes[i] = buildRoute(start, transfers[i], end);
        }

        return routes;
    }
}
