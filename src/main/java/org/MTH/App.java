package org.MTH;

public class App {
    public static void main(String[] args) {
        String[] names = {"Erik Svensson", "Anna Johnson", "John Hans"};

        // Test findByFirstName
        String[] firstNames = NameRepository.findByFirstName(names, "Anna");
        System.out.println("Names with first name Anna:");
        for (String name : firstNames) {
            System.out.println(name);
        }

        // Test findByLastName
        String[] lastNames = NameRepository.findByLastName(names, "Svensson");
        System.out.println("Names with last name Svensson:");
        for (String name : lastNames) {
            System.out.println(name);
        }

        // Test update
        boolean updated = NameRepository.update(names, "Anna Johnson", "Anna Smith");
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
