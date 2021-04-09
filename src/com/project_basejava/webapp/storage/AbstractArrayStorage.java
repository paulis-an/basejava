package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void saveResume(Resume resume, int index) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, index);
            size++;
        } else throw new StorageException("Storage overflow", resume.getUuid());
    }

    protected abstract void saveToArray(Resume resume, int index);

    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        deleteFromArray(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void deleteFromArray(int index);

    @Override
    public List<Resume> getAllSortedResume() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public int size() {
        return size;
    }
}