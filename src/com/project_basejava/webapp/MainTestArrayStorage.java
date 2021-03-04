package com.project_basejava.webapp;

/**
 * Lesson_2 BaseJava
 *
 * @author Pavel Anisimov
 * @version 1.0.0 04.03.2021
 */

import com.project_basejava.webapp.model.Resume;
import com.project_basejava.webapp.storage.ArrayStorage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");
        Resume r5 = new Resume("uuid5");

        arrayStorage.save(r1);
        arrayStorage.save(r2);
        arrayStorage.save(r3);
        arrayStorage.save(r4);
        arrayStorage.save(r5);
        arrayStorage.save(r1);

        System.out.println("Get r1: " + arrayStorage.get(r1.getUuid()));
        System.out.println("Size: " + arrayStorage.size());

        System.out.println("Get dummy: " + arrayStorage.get("dummy"));

        printAll();
        arrayStorage.delete(r1.getUuid());
        printAll();
        arrayStorage.delete(r2.getUuid());
        printAll();
        arrayStorage.delete(r5.getUuid());
        printAll();
        arrayStorage.delete(r1.getUuid());
        printAll();

        arrayStorage.update(r5);

        arrayStorage.save(r3);

        System.out.println("Get r1: " + arrayStorage.get(r1.getUuid()));

        arrayStorage.save(r1);
        printAll();

        arrayStorage.clear();
        printAll();

        System.out.println("Size: " + arrayStorage.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : arrayStorage.getAll()) {
            System.out.println(resume);
        }
    }
}