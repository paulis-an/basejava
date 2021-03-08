package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            if (getIndex(resume.getUuid()) == -1) {
                storage[size] = resume;
                size++;
            } else System.out.println("Резюме с " + resume.getUuid() + " в базе уже есть");
        } else System.out.println("Массив резюме заполнен");
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            return storage[getIndex(uuid)];
        } else System.out.println("Резюме с " + uuid + " в базе нет");
        return null;
    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            storage[getIndex(resume.getUuid())] = resume;
        } else System.out.println("Резюме с " + resume.getUuid() + " в базе нет");
    }


    public void delete(String uuid) {
        if (getIndex(uuid) != -1) {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else System.out.println("Резюме с " + uuid + " в базе нет");
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

    private int getIndex(String uuid) {
        int index;
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                index = i;
                return index;
            }
        }
        return -1;
    }
}