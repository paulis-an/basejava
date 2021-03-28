package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{
    public abstract void clear();

    public abstract void save(Resume resume);

    public abstract Resume get(String uuid);

    public abstract void update(Resume resume);

    public abstract void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public abstract Resume[] getAll();

    public abstract int size();

    protected abstract int getIndex(String uuid);
}
