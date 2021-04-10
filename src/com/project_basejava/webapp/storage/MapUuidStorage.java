package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapUuidStorage extends AbstractStorage {
    private final Map<String, Resume> mapStorage = new TreeMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    public Resume getResume(Object searchKey) {
        return mapStorage.get("uuid" + searchKey);
    }

    @Override
    public void updateResume(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    public void deleteResume(Object searchKey) {
        mapStorage.remove("uuid" + searchKey);
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
    protected Object getSearchKey(String uuid) {
        return mapStorage.containsKey(uuid) ? Integer.parseInt(uuid.substring(4)) : -1;
    }

    @Override
    public boolean isExistResume(Object searchKey) {
        return (Integer) searchKey < 0;
    }
}