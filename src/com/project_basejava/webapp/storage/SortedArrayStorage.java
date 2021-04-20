package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR_UUID = Comparator.comparing(Resume::getUuid);

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
    public Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR_UUID);
    }
}