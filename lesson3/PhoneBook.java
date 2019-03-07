package lesson3;

import java.util.ArrayList;

public class PhoneBook {
    public class PhoneBookData {
        private String name;
        private int phone;

        public PhoneBookData(String name, int phone) {
            this.name = name;
            this.phone = phone;
        }
    }


    ArrayList<PhoneBookData> phoneBook = new ArrayList<>();


    public void add (String name, int phone) {
        phoneBook.add(new PhoneBookData(name, phone ));
    }

    public void print () {
        for (PhoneBookData ph:
        phoneBook) {
            System.out.println(ph.name + " " + ph.phone);
        }
    }

    public void get (String name) {
        for (PhoneBookData ph:
             phoneBook) {
                if (name == ph.name) {
                    System.out.println(ph.name + " " + ph.phone);
                }
        }
    }
}
