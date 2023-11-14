package session6_reflection.test.VIDU;

import lombok.val;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Lab1 {
    public static void main(String[] args) throws ClassNotFoundException {
        getClassInfo();
    }

    private static void getClassInfo() throws ClassNotFoundException {

        // get class by class name

        Class<?> aClass = Class.forName("session6_reflection.entity.Students");

        System.err.println("Name : " + aClass.getName());

        System.err.println("Simple Name : " + aClass.getSimpleName());

        System.err.println("Package : " + aClass.getPackageName());

        int modifier = aClass.getModifiers();

        boolean isPublic = Modifier.isPublic(modifier);

        if (isPublic) System.out.println("Class is public access modifier");

        // get super class

        Class<?> superAClass = aClass.getSuperclass();

        // get interface

        Class<?>[] classInterface = aClass.getInterfaces();

        for (Class<?> a: classInterface) {
            System.out.println(a.getSimpleName());
        }


        Constructor<?>[] constructors = aClass.getConstructors();

        Method[] methods = aClass.getMethods();

        Field[] fields = aClass.getFields();

        Annotation[] annotations = aClass.getAnnotations();

        for (Constructor<?> a: constructors) {
            System.out.println("Constructor : " + a);
        }

        for (Method a: methods) {
            System.out.println("Method : " + a.getName());
        }

        for (Field a: fields) {
            System.out.println("Field : " + a.getAnnotation(val.class));
        }

        for (Annotation a: annotations) {
            System.out.println("Annotation : " + a);
        }

    }

}
