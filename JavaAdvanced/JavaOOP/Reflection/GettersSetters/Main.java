package JavaAdvanced2021.JavaOPP.ReflectionLAB1711.GettersSetters;

import JavaAdvanced2021.JavaOPP.ReflectionLAB1711.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f1, Method s2) {
            boolean firstGetter = f1.getName().startsWith("get");
            boolean secondGetter = s2.getName().startsWith("get");

            if (firstGetter && secondGetter) {
                return f1.getName().compareTo(s2.getName());
            }
            boolean firstSetter = f1.getName().startsWith("set");
            boolean secondSetter = s2.getName().startsWith("set");

            if (firstSetter && secondSetter) {
                return f1.getName().compareTo(s2.getName());
            }
            return Boolean.compare(secondGetter, firstGetter);
        }
    }
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Method[] allMethods = clazz.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(Main::printMethod);

    }

    private static void printMethod(Method method) {
        System.out.println(method.getName().startsWith("get")
                ? String.format("%s will return class %s", method.getName(), method.getReturnType().getSimpleName())
                : String.format("%s and will set field of class %s", method.getName(),method.getParameterTypes()[0]
        .getSimpleName()));
    }
}
