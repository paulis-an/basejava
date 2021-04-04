package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveToArray(Resume resume, int index) {
        index = -index;
        System.arraycopy(storage, index - 1, storage, index, size - (index - 1));
        storage[index - 1] = resume;
    }

    @Override
    protected void deleteFromArray(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
    }

    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}