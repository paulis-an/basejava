package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume, int index) {
        storage[size] = resume;
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