package project_basejava; /**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[storage.length];
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
            if (resume == null) {
                resume= new Resume(uuid);
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if ((storage[i].uuid).equals(uuid)) {
                storage[i] = null;
                if (storage.length - (i + 1) >= 0)
                    System.arraycopy(storage, i + 1, storage, i , storage.length - (i + 1));
                storage[storage.length - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return Arrays.copyOf(storage, i);
            }
        }
        return new Resume[0];
    }

    int size() {
        return storage.length;
    }
}
