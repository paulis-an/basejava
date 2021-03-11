package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    protected int size;

    public int size() {
        return size;
    }
}