package com.project_basejava.webapp.storage;

import com.project_basejava.webapp.exception.ExistStorageException;
import com.project_basejava.webapp.exception.NotExistStorageException;
import com.project_basejava.webapp.model.Resume;
import org.junit.Test;

public abstract class AbstractStorageTest {
    protected static final String UUID_1 = "uuid1";
    protected static final Resume RESUME1 = new Resume(UUID_1);
    protected static final String UUID_2 = "uuid2";
    protected static final Resume RESUME2 = new Resume(UUID_2);
    protected static final String UUID_3 = "uuid3";
    protected static final Resume RESUME3 = new Resume(UUID_3);
    protected static final String UUID_4 = "uuid4";
    protected static final Resume RESUME4 = new Resume(UUID_4);

    @Test
    public abstract void clear();

    @Test
    public abstract void get();

    @Test(expected = NotExistStorageException.class)
    public abstract void getNotExist();

    @Test
    public abstract void update();

    @Test(expected = NotExistStorageException.class)
    public abstract void updateNotExist();

    @Test(expected = NotExistStorageException.class)
    public abstract void delete();

    @Test(expected = NotExistStorageException.class)
    public abstract void deleteNotExist();

    @Test
    public abstract void save();

    @Test(expected = ExistStorageException.class)
    public abstract void saveExist();

    @Test
    public abstract void getAll();

    @Test
    public abstract void size();
}
