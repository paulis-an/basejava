package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    private ArrayList<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, int index) {
        listStorage.add(resume);
    }

    @Override
    public Resume getResume(int index) {
        return listStorage.get(index);
    }

    @Override
    public void updateResume(Resume resume, int index) {
        listStorage.set(index, resume);
    }

    @Override
    protected void deleteResume(int index) {
        listStorage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        return listStorage.contains(r) ? listStorage.indexOf(r) : -1;
    }
}