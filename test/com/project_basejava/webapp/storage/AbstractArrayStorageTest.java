package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.StorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + 1));
            }
        } catch (StorageException e) {
            Assert.fail("Storage overflow ahead of time");
        }
        storage.save(new Resume("Overflow"));
    }
}