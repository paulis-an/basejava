package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {
    private final List<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, Integer searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return listStorage.get(searchKey);
    }

    @Override
    public void updateResume(Resume resume, Integer searchKey) {
        listStorage.set(searchKey, resume);
    }

    @Override
    public void deleteResume(Integer searchKey) {
        listStorage.remove(searchKey.intValue());
    }

    @Override
    public List<Resume> getAllResume() {
        return listStorage;
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean isExistResume(Integer searchKey) {
        return searchKey != null;
    }
}