/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = storage.length;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {

    }

    public Resume get(String uuid) {
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
        return new Resume[0];
    }

    public int size() {
        return size;
    }
}
