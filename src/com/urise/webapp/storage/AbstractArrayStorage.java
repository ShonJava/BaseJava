package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

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


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("not find resume " + r.getUuid());
        } else {
            storage[getIndex(r.getUuid())] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            storage[size] = r;
            size++;
        } else if (size >= storage_limit) {
            System.out.println("Resume[] overflow");
        } else {
            System.out.println(r.getUuid() + " already");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Error, not find resume");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        result = Arrays.copyOfRange (storage, 0, size);
        return result;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}


