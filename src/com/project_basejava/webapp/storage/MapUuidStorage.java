package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private final Map<String, Resume> mapStorage = new TreeMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public void saveResume(Resume resume, String uuid) {
        mapStorage.put(uuid, resume);
    }

    @Override
    public Resume getResume(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    public void updateResume(Resume resume, String uuid) {
        mapStorage.put(uuid, resume);
    }

    @Override
    public void deleteResume(String uuid) {
        mapStorage.remove(uuid);
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
    public boolean isExistResume(String uuid) {
        return mapStorage.containsKey(uuid);
    }
}