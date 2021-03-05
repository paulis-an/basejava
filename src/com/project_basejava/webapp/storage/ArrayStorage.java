package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            if (checkResumeByUuid(resume.getUuid()) == null) {
                storage[size] = resume;
                size++;
            } else System.out.println("Такое резюме в базе уже есть");
        } else System.out.println("Массив резюме заполнен");
    }

    public Resume get(String uuid) {
        if (checkResumeByUuid(uuid) != null) {
            return checkResumeByUuid(uuid);
        } else printAnswer();
        return null;
    }

    public void update(Resume resume) {
        if (checkResumeByUuid(resume.getUuid()) != null) {
            storage[index] = resume;
        } else printAnswer();
    }


    public void delete(String uuid) {
        if (checkResumeByUuid(uuid) != null) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else printAnswer();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private Resume checkResumeByUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                index = i;
                return storage[i];
            }
        }
        return null;
    }

    private void printAnswer() {
        System.out.println("Такого резюме в базе нет");
    }
}