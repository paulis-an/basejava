package com.project_basejava.webapp;

import com.project_basejava.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("uuid1", "dummy");
        Class<? extends Resume> resumeClass = resume.getClass();
        Field field = resumeClass.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);

        Method method = resumeClass.getMethod("toString");
        String returnValue = (String) method.invoke(resume);
        System.out.println(returnValue);
    }
}
