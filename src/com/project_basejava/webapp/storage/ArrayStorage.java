package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(resume.getUuid()) == -1) {
                storage[size] = resume;
                size++;
            } else System.out.println("Резюме с " + resume.getUuid() + " в базе уже есть");
        } else System.out.println("Массив резюме заполнен");
    }

    @Override
    public void deleteResume(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}