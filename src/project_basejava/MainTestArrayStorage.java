package project_basejava;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");

        arrayStorage.save(r1);
        arrayStorage.save(r2);
        arrayStorage.save(r3);

        System.out.println("Get r1: " + arrayStorage.get(r1.uuid));
        System.out.println("Size: " + arrayStorage.size());

        System.out.println("Get dummy: " + arrayStorage.get("dummy"));

        printAll();
        arrayStorage.delete(r1.uuid);
        printAll();
        arrayStorage.clear();
        printAll();

        System.out.println("Size: " + arrayStorage.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : arrayStorage.getAll()) {
            System.out.println(resume);
        }
    }
}
