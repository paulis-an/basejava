package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract void saveResume(Resume resume, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract List<Resume> getAllResume();

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExistResume(Object searchKey);

    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        if (isExistResume(searchKey)) {
            saveResume(resume, searchKey);
        } else throw new ExistStorageException(resume.getUuid());
    }

    public Resume get(String uuid) {
        Object searchKey = getExistException(uuid);
        return getResume(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = getExistException(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistException(uuid);
        deleteResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllResume();
        list.sort(RESUME_COMPARATOR);
        return list;
    }

    private Object getExistException(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExistResume(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}