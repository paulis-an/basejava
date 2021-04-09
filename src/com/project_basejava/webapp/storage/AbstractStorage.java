package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR_NAME = Comparator.comparing(Resume::getFullName);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

    protected abstract List<Resume> getAllSortedResume();

    protected abstract int getIndex(String uuid);

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            saveResume(resume, index);
        } else throw new ExistStorageException(resume.getUuid());
    }

    public Resume get(String uuid) {
        int index = returnIndex(uuid);
        return getResume(index);
    }

    public void update(Resume resume) {
        int index = returnIndex(resume.getUuid());
        updateResume(resume, index);
    }

    public void delete(String uuid) {
        int index = returnIndex(uuid);
        deleteResume(index);
    }

    public List<Resume> getAllSorted(){
        List<Resume> list = getAllSortedResume();
        list.sort(RESUME_COMPARATOR_NAME);
        return list;
    }

    private int returnIndex(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }
}