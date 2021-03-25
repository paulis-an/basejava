package com.project_basejava.webapp.storage;

public class ArrayStorageTest extends AbstractArrayStorageTest {

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Override
    protected String biasUuid() {
        return "uuid3";
    }
}