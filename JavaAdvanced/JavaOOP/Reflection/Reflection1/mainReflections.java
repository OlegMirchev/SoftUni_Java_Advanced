package JavaAdvanced2021.JavaOPP.ReflectionLAB1711.Reflection1;

import JavaAdvanced2021.JavaOPP.ReflectionLAB1711.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class mainReflections {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        Arrays.stream(clazz.getInterfaces()).map(Class::toString).forEach(System.out::println);

        Constructor<Reflection> constructor = clazz.getDeclaredConstructor();

        Reflection reflection = constructor.newInstance();

        System.out.println(reflection);

    }
}
