/*
 * @AUTHOR: chenE2000
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.var;
import java.util.function.Supplier;

public class exp_01_factory {

    // 构建一个基类
    public interface Coin {
        String getDescription();
    }

    // 派生出一个金币类
    public static class GoldCoin implements Coin {

        static final String DESCRIPTION = "This is a gold coin.";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    // 派生出一个铜币类
    public static class CopperCoin implements Coin {

        static final String DESCRIPTION = "This is a copper coin.";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    // 构建一个枚举器
    @RequiredArgsConstructor
    @Getter
    public enum CoinType {
        COPPER(CopperCoin::new),
        GOLD(GoldCoin::new);

        private final Supplier<Coin> constructor;
    }

    // 货币工厂方法
    public static class CoinFactory {
        public static Coin getCoin(CoinType type) {
            return type.getConstructor().get();
        }
    }

    public static void main(String[] args) {
        var coin1 = CoinFactory.getCoin(CoinType.COPPER);
        var coin2 = CoinFactory.getCoin(CoinType.GOLD);
        System.out.println(coin1.getDescription());
        System.out.println(coin2.getDescription());
    }
}
