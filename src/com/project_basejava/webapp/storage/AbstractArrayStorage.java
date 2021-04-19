package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;
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
    public void saveResume(Resume resume, Object searchKey) {
        if (size < STORAGE_LIMIT) {
            saveToArray(resume, (Integer) searchKey);
            size++;
        } else throw new StorageException("Storage overflow", resume.getUuid());
    }

    protected abstract void saveToArray(Resume resume, int index);

    @Override
    protected Resume getResume(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        storage[(Integer) searchKey] = resume;
    }

    @Override
    protected void deleteResume(Object searchKey) {
        deleteFromArray((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void deleteFromArray(int index);

    @Override
    public List<Resume> copyResume() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isExistResume(Object searchKey) {
        return (Integer) searchKey < 0;
    }
}