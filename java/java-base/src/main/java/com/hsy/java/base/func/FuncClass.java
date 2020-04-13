package com.hsy.java.base.func;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path java/com.hsy.java.base.func
 * @date 2019/10/15 14:28
 */
interface Func<E> {
    E call(Object input);
}

public class FuncClass {
    public static Func<Func> yc(final Func<Func> func) {
        return ((Func<Func>) input -> {
            final Func<Func> u = (Func<Func>) input;
            return u.call(u);
        }).call((Func<Func>) input -> {
            final Func<Func> x = (Func<Func>) input;
            return func.call((Func<Object>) input1 -> x.call(x).call(input1));
        });
    }

    public static void main(String[] args) {
        Func<Func> y = yc(input -> {
            final Func<Integer> fab = (Func<Integer>) input;
            return input1 -> {
                Integer n = Integer.parseInt(input1.toString());
                if (n < 2) {
                    return 1;
                } else {
                    return n * fab.call(n - 1);
                }
            };
        });
        System.out.println(y.call(4));
    }
}
