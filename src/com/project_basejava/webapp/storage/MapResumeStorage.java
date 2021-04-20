package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    protected void saveResume(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        Resume r = (Resume) searchKey;
        mapStorage.remove(r.getUuid());
    }

    @Override
    public List<Resume> getAllResume() {
        return new ArrayList<>(mapStorage.values());
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    public boolean isExistResume(Object searchKey) {
        return searchKey == null;
    }
}
