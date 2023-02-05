package JUnit_group.HomeWork7;

import org.eclipse.jdt.core.dom.FieldDeclaration;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        User vPupkin = new User("Василий", "Пупкин", LocalDate.of(1970, 1, 1), 53, "VP", "Passwod1234", "vPupkin@gmial.com");
        Class<? extends User> userClass = vPupkin.getClass();
        // получение через getMethod("name")
        printMethodInfoByName(userClass, "printUserInfo");
        printMethodInfoByName(userClass, "toString");
        // получение через getMethods()
        System.out.println(" получение через getMethods()");
        for (Method method : userClass.getMethods()) {
            printMethodInfo(method);
        }
        //getField("Name")
        // private или protected -- > получаем ошибки
        printFieldInfoByName(userClass,"login");
        printFieldInfoByName(userClass,"password");
        //getFields()
        // private или protected -- > получаем пустой список
        System.out.println("getFields()");
        for(Field field : userClass.getFields()){
            printFieldInfo(field);
            printFieldValue(field, vPupkin);
        }
        //getDeclaredMethod("name")
        System.out.println("//getDeclaredMethod(\"name\")");

        printDeclaredMethodInfoByName(userClass, "setLogin");//не принимает типов поэтому падет ошибка
        //можно было бы попробовать varargs, но непонятно как их передать дальше
        printDeclaredMethodInfoByName(userClass, "getLogin");
        //getDeclaredMethodS()
        System.out.println(" получение через getDeclaredMethodS()");
        for (Method method : userClass.getDeclaredMethods()) {
            printMethodInfo(method);
        }
        //getField("Name")
        // private или protected -- > тут все работает
        printDeclaredFieldInfoByName(userClass,"login");
        printDeclaredFieldInfoByName(userClass,"password");
        //getFields()
        // private или protected -- > получаем пустой список
        System.out.println("getDeclaredFields()");
        for(Field field : userClass.getDeclaredFields()){
            printFieldInfo(field);
            System.out.println("Значение до");
            printFieldValue(field, vPupkin);
            System.out.println("Значение после");//Integer НЕ возможно привести в String
            setFieldValue(field,vPupkin,"123"); //
            printFieldValue(field, vPupkin);
        }

    }
    private static void setFieldValue(Field field, Object object, Object value)
    {
        try{

        field.setAccessible(true);
        field.set(object,value);}
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
    private static void printFieldValue(Field field,Object object){
        try {
            field.setAccessible(true); // ставивм доступным, чтобы можно было достучаться до значения

            Object o = field.get(object);
            System.out.println("Значение поля " + field.getName() + "=  " + field.get(object).toString());
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
    private static void printFieldInfoByName(Class<?> classN, String fieldName) {
        try {
            Field field = classN.getField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    private static void printDeclaredFieldInfoByName(Class<?> classN, String fieldName) {
        try {
            Field field = classN.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void printFieldInfo(Field field) {
        System.out.println("наименование поля " + field.getName());
        System.out.println("isEnumConstant = " + field.isEnumConstant());
        int modifiers = field.getModifiers();
        if (Modifier.isPrivate(modifiers))
            System.out.println("Приватный");
        if (Modifier.isStatic(modifiers))
            System.out.println("Статический");
        if (Modifier.isPublic(modifiers))
            System.out.println("публичный");
        System.out.println("-----------");
    }

    private static void printMethodInfo(Method method) {
        System.out.println("Метод " + method.getName() + " имеет " + method.getParameterCount() + " параметров");
        int modifiers = method.getModifiers();
        if (Modifier.isPrivate(modifiers))
            System.out.println("Приватный");
        if (Modifier.isStatic(modifiers))
            System.out.println("Статический");
        if (Modifier.isPublic(modifiers))
            System.out.println("публичный");
        System.out.println("тип возвращаемого метода  " + method.getGenericReturnType().toString());
        System.out.println("----------------------");

    }

    private static void printMethodInfoByName(Class<?> clas, String method)//нормально работает только для методов без параметров
    {
        try {
            Method m = clas.getMethod(method);
            printMethodInfo(m);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private static void printDeclaredMethodInfoByName(Class<?> clas, String method)//нормально работает только для методов без параметров
    {
        try {
            Method m = clas.getDeclaredMethod(method);
            printMethodInfo(m);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
