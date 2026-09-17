package bad.trainroute.domain;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========");
        System.out.println("ルート検索: 新宿から吉祥寺");
        String route = TrainSystem.getRouteInfo("新宿", "吉祥寺");
        System.out.println(route);

        System.out.println("==========");
        System.out.println("時刻表取得: 新宿");
        String tt = TrainSystem.getTimetableForStation("新宿");
        System.out.println(tt);

        System.out.println("==========");
        System.out.println("駅存在確認: 中野");
        boolean exists = TrainSystem.isValidStation("中野");
        System.out.println("中野 exists: " + exists);

        System.out.println("==========");
        System.out.println("乗り換え経由ルート: 品川から中野");
        String transferRoute = TrainSystem.findAllRoutes("品川", "中野");
        System.out.println(transferRoute);
    }
}
