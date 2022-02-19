import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = storage.length;

    public void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = r;
        }

    }

    public Resume get(String uuid) {
        for(int i = 0; i < storage.length; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            storage[size - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] tempStorage = new Resume[storage.length];
        for (int i = 0; i < storage.length; i++) {
            tempStorage[i] = storage[i];
        }
        return tempStorage;
    }

    public int size() {
        return size;
    }
}
