package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage {
    private List<Resume> listStorage = new ArrayList<>();

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
    public void deleteResume(int index) {
        listStorage.remove(index);
    }

    @Override
    public List<Resume> getAllSortedResume() {
//        listStorage.sort(RESUME_COMPARATOR_NAME);
        return listStorage;
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public int getIndex(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if(listStorage.get(i).getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }
}