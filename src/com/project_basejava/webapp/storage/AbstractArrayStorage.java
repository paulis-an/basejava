package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public abstract void save(Resume resume);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резюме с " + uuid + " в базе нет");
        return null;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else System.out.println("Резюме с " + resume.getUuid() + " в базе нет");
    }

    public abstract void delete(String uuid);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
}