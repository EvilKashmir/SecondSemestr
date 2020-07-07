package inf.lesson1;

import java.util.Date;

public class Cat {

    private String name;
    private Date birthday;
    private int liefs;

    public Cat(Date birthday, String name, int liefs) {
        this.birthday = birthday;
        this.name = name;
        this.liefs = liefs;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public int getLiefs() {
        return liefs;
    }

    public int compareTo(Cat newCat) {
        return (this.liefs - newCat.liefs == 0) ? 0 : (this.liefs > newCat.liefs) ? 1 : -1;
    }
}
