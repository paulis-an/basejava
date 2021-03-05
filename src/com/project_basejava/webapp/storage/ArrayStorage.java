package com.project_basejava.webapp.storage;
/**
 * Array based storage for Resumes
 */

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (checkResume(resume) == null) {
            storage[size] = resume;
            size++;
        } else System.out.println(printAnswer(true));
    }

    public void update(Resume resume) {
        if (checkUuid(resume.getUuid()) != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    storage[i] = resume;
                }
            }
        } else System.out.println(printAnswer(false));
    }


    public Resume get(String uuid) {
        if (checkUuid(uuid) != null) {
            return checkUuid(uuid);
        } else System.out.println(printAnswer(false));
        return null;
    }

    public void delete(String uuid) {
        if (checkUuid(uuid) != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        } else System.out.println(printAnswer(false));
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private String checkResume(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (resume == storage[i]) {
                return storage[i].getUuid();
            }
        }
        return null;
    }

    private Resume checkUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    private String printAnswer(boolean answer) {
        return answer ? "Такое резюме в базе уже есть" : "Такого резюме в базе нет";
    }
}