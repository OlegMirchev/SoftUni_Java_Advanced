package JavaAdvanced2021.JavaOPP.ReflectionExercises1811.harvestingFields.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MainBlackBox {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field fieldInnerValue = clazz.getDeclaredField("innerValue");
        fieldInnerValue.setAccessible(true);

        while (!input.equals("END")) {
            String[] command = input.split("_");
            String methodName = command[0];
            int value = Integer.parseInt(command[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(fieldInnerValue.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}
