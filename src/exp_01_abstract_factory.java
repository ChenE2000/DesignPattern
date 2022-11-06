/*
 * @AUTHOR: chenE2000
 * 实现两个工厂：精灵族的各项设施工厂以及兽人族的各项设施工厂
 * 两个工厂都继承了抽象的大工厂，而大工厂之中包含了三个小的抽象接口
 */

import lombok.var;

public class exp_01_abstract_factory {

    // 抽象城堡接口
    public interface Castle {
        String getDescription();
    }

    // 抽象国王接口
    public interface King {
        String getDescription();
    }

    // 抽象军队
    public interface Army {
        String getDescription();
    }

    // 精灵族的各项派生 ->
    public static class ElfCastle implements Castle {
        static final String DESCRIPTION = "This is the elven castle!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public static class ElfKing implements King {
        static final String DESCRIPTION = "This is the elven king!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public static class ElfArmy implements Army {
        static final String DESCRIPTION = "This is the elven Army!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    // 兽人族的各项派生 ->
    public static class OrcCastle implements Castle {
        static final String DESCRIPTION = "This is the elven castle!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public static class OrcKing implements King {
        static final String DESCRIPTION = "This is the elven king!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public static class OrcArmy implements Army {
        static final String DESCRIPTION = "This is the elven Army!";

        @Override
        public String getDescription() {
            return DESCRIPTION;
        }
    }

    // 抽象工厂三合一
    public interface KingdomFactory {
        Castle createCastle();
        King createKing();
        Army createArmy();
    }

    public static class ElfKingdomFactory implements KingdomFactory {

        @Override
        public Castle createCastle() {
            return new ElfCastle();
        }

        @Override
        public King createKing() {
            return new ElfKing();
        }

        @Override
        public Army createArmy() {
            return new ElfArmy();
        }
    }

    public static class OrcKingdomFactory implements KingdomFactory {

        @Override
        public Castle createCastle() {
            return new OrcCastle();
        }

        @Override
        public King createKing() {
            return new OrcKing();
        }

        @Override
        public Army createArmy() {
            return new OrcArmy();
        }
    }

    public static void main(String[] args) {
        // 生成一个精灵族的工厂
        var factory = new ElfKingdomFactory();
        var castle = factory.createCastle();
        var king = factory.createKing();
        var army = factory.createArmy();

        System.out.println(castle.getDescription());
        System.out.println(king.getDescription());
        System.out.println(army.getDescription());
    }
}
