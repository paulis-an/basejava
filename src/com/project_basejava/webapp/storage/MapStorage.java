package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public class MapStorage extends AbstractStorage{
    @Override
    public void clear() {

    }

    @Override
    public void saveRes(Resume resume, int index) {

    }

    @Override
    public Resume getRes(int index) {
        return null;
    }

    @Override
    public void updateRes(Resume resume, int index) {

    }

    @Override
    public void deleteRes(int index) {

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
