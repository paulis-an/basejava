package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            int index = getIndex(resume.getUuid());
            int positiveIndex = -index - 1;
            if (index < 0) {
                System.arraycopy(storage, positiveIndex, storage, positiveIndex + 1, storage.length - (positiveIndex + 1));
                storage[positiveIndex] = resume;
                size++;
            } else System.out.println("Резюме с " + resume.getUuid() + " в базе уже есть");
        } else System.out.println("Массив резюме заполнен");
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            System.arraycopy(storage, index + 1, storage, index, size - (index + 1));
            size--;
        } else System.out.println("Резюме с " + uuid + " в базе нет");
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
