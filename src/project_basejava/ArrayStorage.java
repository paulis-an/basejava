package project_basejava; /**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            return (resume.uuid).equals(uuid) ? resume : null;
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if ((storage[i].uuid).equals(uuid)) {
                storage[i] = null;
                if (storage.length - (i + 1) >= 0) {
                    System.arraycopy(storage, i + 1, storage, i, storage.length - 1);
                    storage[storage.length - 1] = null;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            } else break;
        }
        return size;
    }
}
