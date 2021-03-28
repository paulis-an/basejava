package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    private final Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void get() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        assertGet(r);
        assertGet(RESUME1);
        assertGet(RESUME2);
        assertGet(RESUME3);
    }

    @Override
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_1);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_1));
    }

    @Override
    public void updateNotExist() {
        storage.update(new Resume("dummy"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Override
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void save() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        assertSize(4);
        assertGet(r);
    }

    @Override
    public void saveExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() throws IndexOutOfBoundsException {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflow ahead of time");
        }
        storage.save(new Resume());
    }

    @Test
    public void getAll() {
        Resume[] r = {RESUME1, RESUME2, RESUME3};
        Assert.assertEquals(3, storage.getAll().length);
        Assert.assertArrayEquals(r, storage.getAll());
    }

    @Test
    public void size() {
        assertSize(3);
    }

    private void assertGet(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }
}