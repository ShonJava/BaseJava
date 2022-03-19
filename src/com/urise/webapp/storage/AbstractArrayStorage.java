package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int storage_limit = 10000;
    protected Resume[] storage = new Resume[storage_limit];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Error, resume not find");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);


}


