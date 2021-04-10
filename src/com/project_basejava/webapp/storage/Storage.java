package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void save(Resume resume);

    Object get(String uuid);

    void update(Resume resume);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
//    Resume[] getAll();

    List<Resume> getAllSorted();

    int size();
}