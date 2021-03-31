package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected static ArrayList<Resume> LIST_STORAGE = new ArrayList<>();

    @Override
    public void clear() {
        LIST_STORAGE.clear();
    }

    @Override
    public void saveRes(Resume resume, int index) {
        LIST_STORAGE.add(resume);
    }

    @Override
    public Resume getRes(int index) {
        return LIST_STORAGE.get(index);
    }

    @Override
    public void updateRes(Resume resume, int index) {
        LIST_STORAGE.set(index, resume);
    }

    @Override
    protected void deleteRes(int index) {
        LIST_STORAGE.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return LIST_STORAGE.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return LIST_STORAGE.size();
    }

    @Override
    protected int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        if (LIST_STORAGE.contains(r)) {
            return LIST_STORAGE.indexOf(r);
        }
        return -1;
    }
}