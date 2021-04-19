package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public static final Comparator<Resume> RESUME_COMPARATOR_NAME = Comparator.comparing(Resume::getFullName);

    private static final Comparator<Resume> RESUME_COMPARATOR_UUID = Comparator.comparing(Resume::getUuid);

    protected abstract void saveResume(Resume resume, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract List<Resume> copyResume();

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExistResume(Object searchKey);

    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        if (isExistResume(searchKey)) {
            saveResume(resume, searchKey);
        } else throw new ExistStorageException(resume.getUuid());
    }

    public Resume get(String uuid) {
        Object searchKey = getNotExistException(uuid);
        return getResume(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = getNotExistException(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getNotExistException(uuid);
        deleteResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = copyResume();
        list.sort(RESUME_COMPARATOR_NAME);
        return list;
    }

    private Object getNotExistException(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExistResume(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }
}