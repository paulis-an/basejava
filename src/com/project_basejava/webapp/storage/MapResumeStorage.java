package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected void saveResume(Resume resume, Resume r) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }

    @Override
    protected void updateResume(Resume resume, Resume r) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Resume resume) {
        mapStorage.remove(resume.getUuid());
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
    public boolean isExistResume(Resume resume) {
        return resume != null;
    }
}
