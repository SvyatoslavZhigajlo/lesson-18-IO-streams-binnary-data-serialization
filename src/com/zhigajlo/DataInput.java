package com.zhigajlo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class DataInput {

    public void dataInputStream() throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream("textStringInt.bin"))) {
            String name = dataInputStream.readUTF();
            int birthDate = dataInputStream.readInt();
            String telephoneNumber = dataInputStream.readUTF();
            Contact dataInputStreamToContact = new Contact(name, telephoneNumber, birthDate);
            System.out.println(dataInputStreamToContact);
        }
    }

    public void dataInputStreamCollectionStrings() throws IOException {
        Collection<String> inputStreamCollection = new ArrayList<>();
        try (DataInputStream dataInputStreamCollectionStrings = new DataInputStream(
                new FileInputStream("textCollectionNames.bin"))) {
            while (dataInputStreamCollectionStrings.available() > 0) {
                inputStreamCollection.add(dataInputStreamCollectionStrings.readUTF());
            }
        }
        System.out.println("\nПрочитанная коллекция String:");
        for (String showInfo : inputStreamCollection) {
            System.out.println(showInfo);
        }
    }

    public void dataInputStreamCollectionContacts() throws IOException {
        Collection<Contact> collectionInputContacts = new ArrayList<>();
        try (DataInputStream dataInputStreamCollectionContacts = new DataInputStream(
                new FileInputStream("CollectionContactList.bin"))) {
            while (dataInputStreamCollectionContacts.available() > 0) {
                collectionInputContacts.add(new Contact(
                        dataInputStreamCollectionContacts.readUTF(),
                        dataInputStreamCollectionContacts.readUTF(),
                        dataInputStreamCollectionContacts.readInt()));
            }
        }
        System.out.println("\nПрочтенный бинарный файл с коллекцией Контактов");
        for (Contact collectionContacts : collectionInputContacts) {
            System.out.println(collectionContacts);
        }
    }

    public void contactsInputStreamSerializable() throws IOException, ClassNotFoundException {
        Collection<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("ContactsSerializable.bin"))) {
            contacts = ((ArrayList<Contact>) ois.readObject());
        }
        System.out.println("\nПрочтенный бинарный файл с коллекцией Контактов через Serializable");
        for (Contact showContact : contacts) {
            System.out.println(showContact);
        }
    }
}
