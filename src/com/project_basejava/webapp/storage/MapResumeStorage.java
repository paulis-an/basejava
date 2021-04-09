package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected void saveResume(Resume resume, int index) {
        mapStorage.put(resume.getFullName(), resume);
    }

    @Override
    protected Resume getResume(int index) {
        return mapStorage.get(mapStorage.get(index).getFullName());
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        mapStorage.put(resume.getFullName(), resume);
    }

    @Override
    protected void deleteResume(int index) {
        mapStorage.remove(mapStorage.get(index).getFullName());
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllSortedResume() {
        return new ArrayList<>(mapStorage.values());
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}
