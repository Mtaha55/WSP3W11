package org.MTH;

public class NameRepository {
    public static String[] findByFirstName(final String[] names, final String firstName) {
        int count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length >= 1 && parts[0].equals(firstName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        int index = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length >= 1 && parts[0].equals(firstName)) {
                matches[index++] = name;
            }
        }
        return matches;
    }

    public static String[] findByLastName(final String[] names, final String lastName) {
        int count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length >= 2 && parts[1].equals(lastName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        int index = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length >= 2 && parts[1].equals(lastName)) {
                matches[index++] = name;
            }
        }
        return matches;
    }

    public static boolean update(final String[] names, final String original, final String updatedName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                String[] parts = updatedName.split("\\s+");
                if (parts.length != 2) {
                    return false; // updatedName must have both first name and last name
                }
                for (int j = 0; j < names.length; j++) {
                    if (i != j && names[j].equals(updatedName)) {
                        return false; // updatedName already exists
                    }
                }
                names[i] = updatedName;
                return true; // name updated successfully
            }
        }
        return false; // original name not found
    }

    public static void main(String[] args) {
        String[] names = {"Erik Svensson", "Anna Johnson", "John Hans"};

        // Test findByFirstName
        String[] firstNames = findByFirstName(names, "Anna");
        System.out.println("Names with first name Anna:");
        for (String name : firstNames) {
            System.out.println(name);
        }

        // Test findByLastName
        String[] lastNames = findByLastName(names, "Svensson");
        System.out.println("Names with last name Svensson:");
        for (String name : lastNames) {
            System.out.println(name);
        }

        // Test update
        boolean updated = update(names, "Anna Johnson", "Anna Smith");
        if (updated) {
            System.out.println("Name updated successfully.");
        } else {
            System.out.println("Name could not be updated.");
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
