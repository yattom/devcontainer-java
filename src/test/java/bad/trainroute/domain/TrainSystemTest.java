
package bad.trainroute.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TrainSystemTest {
    @Test
    void testルート検索_新宿から吉祥寺_できる() {
        String actual = TrainSystem.getRouteInfo("新宿", "吉祥寺");
		assertEquals(actual, "新宿で中央線に乗車して、吉祥寺で下車します。");
    }

    @Test
    void testルート検索_存在しない駅だから見つからない() {
        String actual = TrainSystem.getRouteInfo("新宿", "存在しない");
		assertEquals(actual, "駅が見つかりません");
    }

    @Test
    void testルート検索_吉祥寺から新宿_逆向きだから不正() {
        String actual = TrainSystem.getRouteInfo("吉祥寺", "新宿");
		assertEquals(actual, "不正なルートです");
    }

    @Test
    void testルート検索_新宿から新宿_同じ駅だから不正() {
        String actual = TrainSystem.getRouteInfo("新宿", "新宿");
		assertEquals(actual, "不正なルートです");
    }

	@Test
    void testルート検索_山手線上野から品川が検索できる() {
        String actual = TrainSystem.getRouteInfo("上野", "品川");
		assertEquals(actual, "上野で山手線に乗車して、品川で下車します。");
    }

	@Test
    void test存在チェック新宿駅が中央線にある() {
		assertTrue(DataStore.isStationOnLine("新宿", "中央線"));
    }

}
