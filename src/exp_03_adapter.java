/*
 * @AUTHOR: chenE2000
 * 通过适配器模式模仿手机充电接口的适配情形
 */

// USB-A接头
class USBA {
    public void transmit() {
        System.out.println("USB-A 传输数据中...");
    }
}

// Type-C接头
class TypeC {
    public void transmit() {
        System.out.println("Type-C 传输数据中...");
    }
}

// 手机用只能Type-C接口连接电脑传输数据
class Phone {
    public void connect(TypeC typeC) {
        typeC.transmit();
    }
}

// Type-C适配器
class TypeCAdapter extends TypeC {
    private final USBA usba;

    public TypeCAdapter(USBA usba) {
        this.usba = usba;
    }

    @Override
    public void transmit() {
        usba.transmit();
    }
}

public class exp_03_adapter {
    public static void main(String[] args) {
        USBA usba = new USBA();
        Phone phone = new Phone();
        phone.connect(new TypeCAdapter(usba));
    }
}

