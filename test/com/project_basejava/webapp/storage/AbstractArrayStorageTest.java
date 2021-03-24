package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private final String uuid;
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage, String uuid) {
        this.storage = storage;
        this.uuid = uuid;
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
        storage.size();
    }

    @Test
    public void get() {
        Assert.assertEquals(getResumeStorage()[0], storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(storage.get("dummy"));
    }

    @Test
    public void update() {
        Resume r10 = new Resume(UUID_1);
        storage.update(r10);
        Assert.assertEquals(getResumeStorage()[0], r10);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(getResumeStorage()[0], storage.get(uuid));
    }

    @Test
    public void saveExist() {
        storage.get("uuid3");
    }

    @Test
    public void save() {
        Resume r = new Resume("uuid4");
        storage.save(r);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals((getResumeStorage()[3]), storage.get("uuid4"));
    }

    @Test
    public void getAll() {
        Assert.assertEquals(getResumeStorage().length, storage.size());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getExist() {
        storage.get("uuid1");
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

    public Resume[] getResumeStorage() {
        return storage.getAll();

    }
}