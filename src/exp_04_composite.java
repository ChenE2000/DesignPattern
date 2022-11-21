/*
 * @AUTHOR: chenE2000
 * 设计一个公司的人员分布结构
 */

import java.util.ArrayList;
import java.util.List;


// 一个抽象的组件类
abstract class Component {
    // 职位
    private final String position;
    // 工作内容
    private final String job;

    public Component(String position, String job) {
        this.position = position;
        this.job = job;
    }

    // 做自己的本职工作
    public void work() {
        System.out.println("我是" + position + "，我正在" + job);
    }

    abstract void addComponent(Component component);

    abstract void removeComponent(Component component);

    abstract void check();
}


// 管理者继承自此抽象类
class Manager extends Component {
    // 管理的组件
    private final List<Component> components = new ArrayList<>();

    public Manager(String position, String job) {
        super(position, job);
    }

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    void removeComponent(Component component) {
        components.remove(component);
    }

    // 检查下属
    @Override
    public void check() {
        work();
        for (Component component : components) {
            component.check();
        }
    }
}


// 职员同样继承自此抽象类
class Employee extends Component {

    public Employee(String position, String job) {
        super(position, job);
    }

    @Override
    void addComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    void removeComponent(Component component) {
        System.out.println("职员没有管理权限");
    }

    @Override
    void check() {
        work();
    }
}


public class exp_04_composite {
    public static void main(String[] args) {
        Component boss = new Manager("老板", "主持会议");
        Component HR = new Employee("人力资源", "聊微信");
        Component PM = new Manager("产品经理", "不知道干啥");
        Component CFO = new Manager("财务主管", "看剧");
        Component CTO = new Manager("技术主管", "划水");
        Component UI = new Employee("设计师", "画画");
        Component operator = new Employee("运营人员", "兼职客服");
        Component webProgrammer = new Employee("程序员", "学习设计模式");
        Component backgroundProgrammer = new Employee("后台程序员", "CRUD");
        Component accountant = new Employee("会计", "背九九乘法表");
        Component clerk = new Employee("文员", "给老板递麦克风");
        boss.addComponent(HR);
        boss.addComponent(PM);
        boss.addComponent(CFO);
        PM.addComponent(UI);
        PM.addComponent(CTO);
        PM.addComponent(operator);
        CTO.addComponent(webProgrammer);
        CTO.addComponent(backgroundProgrammer);
        CFO.addComponent(accountant);
        CFO.addComponent(clerk);

        boss.check();
    }


}
