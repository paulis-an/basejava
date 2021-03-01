package com.project_basejava.webapp.storage;
/**
 * Array based storage for Resumes
 */

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void clear() {
        for (int i = 0; i < getSize(); i++) {
            storage[i] = null;
        }
        setSize(0);
    }

    public void save(Resume resume) {
        storage = Arrays.copyOf(storage, getSize() + 1);
        storage[getSize()] = resume;
        setSize(getSize() + 1);
    }

    public Resume get(String uuid) {
        for (int i = 0; i < getSize(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < getSize(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[getSize() - 1];
                storage[getSize() - 1] = null;
                break;
            }
        }
        storage = Arrays.copyOf(storage, getSize() - 1);
        setSize(getSize() - 1);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, getSize());
    }

    public int size() {
        return getSize();
    }
}
