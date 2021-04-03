package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new TreeMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, int index) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    public Resume getResume(int index) {
        return mapStorage.get("uuid" + index);
    }

    @Override
    public void updateResume(Resume resume, int index) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    public void deleteResume(int index) {
        mapStorage.remove("uuid" + index);
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    public int getIndex(String uuid) {
        return mapStorage.containsKey(uuid) ? Integer.parseInt(uuid.substring(4)) : -1;
    }
}
