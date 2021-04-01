package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    protected static Map<String, Resume> MAP_STORAGE = new TreeMap<>();

    @Override
    public void clear() {
        MAP_STORAGE.clear();
    }

    @Override
    public void saveRes(Resume resume, int index) {
        MAP_STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    public Resume getRes(int index) {
        return MAP_STORAGE.get("uuid" + index);
    }

    @Override
    public void updateRes(Resume resume, int index) {
        MAP_STORAGE.put(resume.getUuid(), resume);
    }

    @Override
    public void deleteRes(int index) {
        MAP_STORAGE.remove("uuid" + index);
    }

    @Override
    public Resume[] getAll() {
        return MAP_STORAGE.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return MAP_STORAGE.size();
    }

    @Override
    public int getIndex(String uuid) {
        if (MAP_STORAGE.containsKey(uuid)) {
            return Integer.parseInt(uuid.substring(4));
        }
        return -1;
    }
}
