package inf.lesson1;

public class UnGenericsContainer <T1, T2> {
    private final T1 obj1;
    private final T2 obj2;


    public  UnGenericsContainer(T1 obj1, T2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T1 getVal1() {
        return obj1;
    }

    public T2 getVal2() {
        return obj2;
    }

    public Class getType1() {
        return this.obj1.getClass();
    }

    public Class getType2() {
        return this.obj1.getClass();
    }
}
