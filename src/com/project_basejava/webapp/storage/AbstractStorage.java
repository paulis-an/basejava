package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            saveResume(resume, index);
        } else throw new ExistStorageException(resume.getUuid());
    }

    protected abstract void saveResume(Resume resume, int index);

    public Resume get(String uuid) {
        int index = indexUuid(uuid);
        return getResume(index);
    }

    protected abstract Resume getResume(int index);

    public void update(Resume resume) {
        int index = indexUuid(resume.getUuid());
        updateResume(resume, index);
    }

    protected abstract void updateResume(Resume resume, int index);

    public void delete(String uuid) {
        int index = indexUuid(uuid);
        deleteResume(index);
    }

    protected abstract void deleteResume(int index);

    private int indexUuid(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }
}