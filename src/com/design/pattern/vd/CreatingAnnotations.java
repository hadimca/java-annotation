package com.design.pattern.vd;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class CreatingAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat myCat = new Cat("Simba2");

        if(myCat.getClass().isAnnotationPresent(VeryImportant.class))
            System.out.println("This class is very important");

        for(Method method: myCat.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++ ) {
                    method.invoke(myCat);
                }
            }
        }

        for (Field field: myCat.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(ImportantString.class)){
                Object objectValue = field.get(myCat);
                if(objectValue instanceof String ){
                    String stringValue = (String) objectValue;
                    System.out.println(stringValue.toLowerCase());
                }
            }
        }
            
    }
}
