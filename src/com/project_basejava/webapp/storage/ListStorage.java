package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected static ArrayList<Resume> LIST_STORAGE = new ArrayList<>();

    @Override
    public void clear() {
        LIST_STORAGE.clear();
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            throw new ExistStorageException(resume.getUuid());
        } else LIST_STORAGE.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        } else return LIST_STORAGE.get(index);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            throw new NotExistStorageException(resume.getUuid());
        } else LIST_STORAGE.set(index, resume);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            throw new NotExistStorageException(uuid);
        } else LIST_STORAGE.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return LIST_STORAGE.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return LIST_STORAGE.size();
    }

    protected int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        if (LIST_STORAGE.contains(r)) {
            return LIST_STORAGE.indexOf(r);
        }
        return -1;
    }
}