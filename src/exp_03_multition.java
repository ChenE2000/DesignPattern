/*
 * @AUTHOR: chenE2000
 * 多例模式实际上就是单例模式的自然推广，属于对象创建类型的模式
 * 多例模式其实就是限制了对象的数量，并且有可能对对象进行重复使用
 */

import java.util.ArrayList;
import java.util.Random;

class Person {
    private final String name;

    // 保持构造方法私有
    private Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private static ArrayList<Person> list = new ArrayList<>();
    static {
        // 只能产生三个该类的实例对象
        for(int i = 0; i < 3; i++){
            Person p = new Person("person"+i);
            list.add(p);
        }
    }

    // 供一个静态方法来随机获取一个该类的实例对象
    public static Person getInstance(){
        // 随机返回其中一个对象
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

public class exp_03_multition {
    public static void main (String[] args) {
        for(int i = 0; i < 5; i++){
            Person person = Person.getInstance();
            System.out.println(person);
        }
    }
}
