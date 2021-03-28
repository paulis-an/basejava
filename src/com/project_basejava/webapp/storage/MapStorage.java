package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public class MapStorage extends AbstractStorage{
    @Override
    public void clear() {

    }

    @Override
    public void save(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int getIndex(String uuid) {
        return 0;
    }
}
