package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    private static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index < 0) {
                saveResume(resume, index);
                size++;
            } else throw new ExistStorageException(resume.getUuid());
        } else throw new StorageException("Storage overflow", resume.getUuid());
    }

    protected abstract void saveResume(Resume resume, int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else return storage[index];
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else storage[index] = resume;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void deleteResume(int index);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}