package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest {
    private ListStorage arrayList = new ListStorage();

    @Before
    public void setUp() {
        arrayList.clear();
        arrayList.save(RESUME1);
        arrayList.save(RESUME2);
        arrayList.save(RESUME3);
    }

    @Test
    public void clear() {
        System.out.println(arrayList.toString());
        arrayList.clear();
        assertSize(0);
    }

    @Test
    public void save() {
        arrayList.save(RESUME4);
        assertSize(4);
        Assert.assertEquals(new Resume("uuid4"), arrayList.get(UUID_4));
    }

    @Override
    public void saveExist() {
        arrayList.save(new Resume(UUID_1));
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume("uuid1"), arrayList.get(UUID_1));
        Assert.assertEquals(new Resume("uuid2"), arrayList.get(UUID_2));
        Assert.assertEquals(new Resume("uuid3"), arrayList.get(UUID_3));
    }

    @Override
    public void getNotExist() {
        arrayList.get("dummy");
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_1);
        arrayList.update(r);
        Assert.assertEquals(r, arrayList.get(UUID_1));
    }

    @Override
    public void updateNotExist() {
        arrayList.update(new Resume("dummy"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        arrayList.delete(UUID_1);
        assertSize(2);
        arrayList.get(UUID_1);
    }

    @Override
    public void deleteNotExist() {
        arrayList.delete("dummy");
    }

    @Test
    public void getAll() {
        Resume[] r = {RESUME1, RESUME2, RESUME3};
        Assert.assertEquals(3, arrayList.getAll().length);
        Assert.assertArrayEquals(r, arrayList.getAll());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, arrayList.size());
    }

    @Test
    public void getIndex() {
        Assert.assertEquals(0, arrayList.getIndex(UUID_1));
        Assert.assertEquals(1, arrayList.getIndex(UUID_2));
        Assert.assertEquals(2, arrayList.getIndex(UUID_3));
    }

    private void assertSize(int size) {
        Assert.assertEquals(size, arrayList.size());
    }
}