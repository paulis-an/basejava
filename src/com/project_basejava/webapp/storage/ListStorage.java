package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage {
    private final List<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, Object searchKey) {
        listStorage.add(resume);
    }

    @Override
    public Resume getResume(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }

    @Override
    public void updateResume(Resume resume, Object searchKey) {
        listStorage.set((Integer) searchKey, resume);
    }

    @Override
    public void deleteResume(Object searchKey) {
        int sk = (Integer) searchKey;
        listStorage.remove(sk);
    }

    @Override
    public List<Resume> getAllSortedResume() {
        return listStorage;
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public Object getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isExistResume(Object searchKey) {
        return (Integer) searchKey < 0;
    }
}