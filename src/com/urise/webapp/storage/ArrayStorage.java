package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    ArrayList<Resume> storage = new ArrayList<Resume>(STORAGE_LIMIT);
    int size = 0;

    public void clear() {
        Arrays.fill(new ArrayList[]{storage}, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {

    }

    public void save(Resume r) {
        if (storage.indexOf(r) != -1) {
            System.out.println("This uuid" + r.getUuid() + " is already");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Overflow");
        } else {
            storage.add(size, r);
            System.out.println("you save uuid");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i <= size; i++) {
            Resume r = storage.get(i);
            if (r.getUuid() == uuid) {
                return storage.get(i);
            } else {
                System.out.println("not find resume");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i <= size; i ++) {
            Resume r = storage.get(i);
            if (r.getUuid().equals(uuid)) {
                storage.remove(i);
            }
        }
    }

    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        result = (Resume[]) storage.clone();
        return result;
    }

    public int size() {
        return size;
    }

    private int getIndex(Resume r) {
        return storage.indexOf(r);
    }

}


