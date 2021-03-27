package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assert.assertEquals(r, storage.get("uuid4"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_1);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume("dummy"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        Resume r = new Resume(UUID_3);
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(r, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void save() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(r, storage.get("uuid4"));
    }

    @Test
    public void getAll() {
        Resume[] r = {new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(r, storage.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() throws IndexOutOfBoundsException {
        storage.clear();
        try {
            for (int i = 0; i < 10_000; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflow ahead of time");
        }
        storage.save(new Resume());
    }
}