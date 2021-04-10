package com.project_basejava.webapp;

/**
 * Lesson_6 BaseJava
 *
 * @author Pavel Anisimov
 * @version 10.04.2021
 */

import com.project_basejava.webapp.model.Resume;
import com.project_basejava.webapp.storage.*;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ListStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "Petrov Sergey");
        final Resume r2 = new Resume("uuid2", "Ivanov Daniil");
        final Resume r3 = new Resume("uuid3", "Kinchev Konstantin");
        final Resume r4 = new Resume("uuid4", "Spirin Dmitriy");
        final Resume r5 = new Resume("uuid5", "Puh Anton");
        final Resume r6 = new Resume("uuid2", "Ivanov Sergey");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r5);
//        ARRAY_STORAGE.save(r1);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.delete(r3.getUuid());
        printAll();
        ARRAY_STORAGE.delete(r5.getUuid());
        printAll();
//        ARRAY_STORAGE.delete(r1.getUuid());
//        printAll();

//        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.update(r6);
        System.out.println("Update resume - uuid2");
        printAll();
        ARRAY_STORAGE.save(r3);
        printAll();

//        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));

        ARRAY_STORAGE.save(r1);
        printAll();

        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(resume);
        }
        System.out.println();
    }
}