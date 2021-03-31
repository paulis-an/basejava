package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    public abstract void clear();

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            saveRes(resume, index);
        } else throw new ExistStorageException(resume.getUuid());
    }

    protected abstract void saveRes(Resume resume, int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else return getRes(index);
    }

    protected abstract Resume getRes(int index);

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else updateRes(resume, index);
    }

    protected abstract void updateRes(Resume resume, int index);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else deleteRes(index);
    }

    protected abstract void deleteRes(int index);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public abstract Resume[] getAll();

    public abstract int size();

    protected abstract int getIndex(String uuid);
}