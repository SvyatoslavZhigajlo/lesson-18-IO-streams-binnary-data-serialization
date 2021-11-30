package com.zhigajlo;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class DataOutput {

    public void dataOutputStream(Contact contact1) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new FileOutputStream("textStringInt.bin"))) {
            dataOutputStream.writeUTF(contact1.getName());
            dataOutputStream.writeInt(contact1.getBirthday());
            dataOutputStream.writeUTF(contact1.getPhoneNumber());
        }
    }

    public void dataOutputStreamCollectionStrings(Collection<String> collectionNames) throws IOException {
        try (DataOutputStream dataOutputStreamCollectionStrings = new DataOutputStream(
                new FileOutputStream("textCollectionNames.bin"))) {
            for (String inputCollection : collectionNames) {
                dataOutputStreamCollectionStrings.writeUTF(inputCollection);
            }
        }
    }

    public void dataOutputStreamCollectionContacts(Collection<Contact> contactsList) throws IOException {
        try (DataOutputStream dataOutputStreamCollectionContacts = new DataOutputStream(
                new FileOutputStream("CollectionContactList.bin"))) {
            for (Contact outputData : contactsList) {
                dataOutputStreamCollectionContacts.writeUTF(outputData.getName());
                dataOutputStreamCollectionContacts.writeUTF(outputData.getPhoneNumber());
                dataOutputStreamCollectionContacts.writeInt(outputData.getBirthday());
            }
        }
    }

    public void contactsOutStreamSerializable(Collection<Contact> contactsList) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("ContactsSerializable.bin"))) {
            oos.writeObject(contactsList);

        }
    }
}
