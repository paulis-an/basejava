package com.project_basejava.webapp.storage;
/**
 * Array based storage for Resumes
 */

import com.project_basejava.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume resume) {
        if (!checkResume(resume)) {
            try {
                storage[size] = resume;
                size++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Превышен размер массива резюме");
            }
        } else System.out.println(printAnswer(checkResume(resume)));
    }

    public void update(Resume resume) {
        if (checkResume(resume)) {
            new Resume(resume.getUuid());
        } else System.out.println(printAnswer(checkResume(resume)));
    }

    public Resume get(String uuid) {
        if (checkUuid(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (checkUuid(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
        }
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

    private boolean checkResume(Resume resume) {
        for (Resume res : storage) {
            if (resume == res) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUuid(String uuid) {
        try {
            for (Resume res : storage) {
                if (uuid.equals(res.getUuid())) {
                    return true;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(printAnswer(false));
        }
        return false;
    }

    private String printAnswer(boolean answer) {
        return answer ? "Такое резюме в базе уже есть" : "Такого резюме в базе нет";
    }
}