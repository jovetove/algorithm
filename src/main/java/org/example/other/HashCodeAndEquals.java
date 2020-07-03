package org.example.other;

import java.util.Objects;

/**
 * 重写hashcode 和 equals
 * 1. 自反性（reflective）：对于任何非null的引用值必须满足x.equals(x)必须为true。
 * 2. 对称性（symmetric）：对于任何非null的引用值x,y。当且仅当x.equals(y)为true的时候，y.equals(x)一定为true。
 * 3. 传递性（transitive）：对于任何非null的引用值x,y,z。当且仅当x.equals(y)为true的时候且y.equals(z)为true，x.equals(z)一定为true。
 * 4. 对于任何非null的引用值x，x.equals(null)一定返回false。
 * @author minglan
 */
public class HashCodeAndEquals {

}

class Cat{
    public long id;
    public String name;
    public String sex;
    public int weight;

    public Cat(String name) {
        this.name = name;


    }

    @Override
    public boolean equals(Object o) {
        // 这里使用==显示判断比较对象是否是同一对象
        if (this == o) {
            return true;
        }

        if (!(o instanceof Cat)) {
            return false;
        }

        Cat cat = (Cat) o;
        return id == cat.id &&
                weight == cat.weight &&
                name.equals(cat.name) &&
                sex.equals(cat.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, weight);
    }
}