package com.zhigajlo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Contact contact1 = new Contact("Svyatoslav1", "(066)1234567", 26112021);
        Contact contact2 = new Contact("Svyatoslav2", "(066)1234568", 27112021);
        Contact contact3 = new Contact("Svyatoslav3", "(066)1234569", 28112021);
        Contact contact4 = new Contact("Svyatoslav4", "(066)1234571", 29112021);
        Collection<Contact> contactsList = new ArrayList<>();
        contactsList.add(contact1);
        contactsList.add(contact2);
        contactsList.add(contact3);
        contactsList.add(contact4);
        Collection<String> namesOfContacts = new ArrayList<>();
        namesOfContacts.add(contact1.getName());
        namesOfContacts.add(contact2.getName());
        namesOfContacts.add(contact3.getName());
        namesOfContacts.add(contact4.getName());

        try {
            DataOutput dataOutput = new DataOutput();
            //ДЗ 21 Задание 1 - Записать в бинарный файл несколько разнотипных значений,
            //используя DataOutputStream.
            dataOutput.dataOutputStream(contact1);

            //ДЗ 21 Задание 3 - Записать в бинарный файл коллекцию строк (String)
            dataOutput.dataOutputStreamCollectionStrings(namesOfContacts);

            //ДЗ 21 Задание 4 -   Записать в бинарный файл коллекцию контактов (Contact)
            dataOutput.dataOutputStreamCollectionContacts(contactsList);

//            ДЗ 21 Задание 5 - Записать в бинарный файл коллекцию контактов (Contact) используя Serializable.
            dataOutput.contactsOutStreamSerializable(contactsList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInput dataInput = new DataInput();
            //ДЗ 21 Задание 2 - Прочитать записанные данные из предыдущего задания используя DataInputStream.
            dataInput.dataInputStream();

//            ДЗ 21 Задание 3 - Прочитать из бинарного файла коллекцию строк (String)
            dataInput.dataInputStreamCollectionStrings();

//            ДЗ 21 Задание 4 -   Прочитать из бинарный файла коллекцию контактов (Contact)
            dataInput.dataInputStreamCollectionContacts();

//            ДЗ 21 Задание 5 - Прочитать из бинарного файла коллекцию контактов (Contact) используя Serializable.
            dataInput.contactsInputStreamSerializable();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//            ДЗ 21 Задание 6 - Посчитать количество файлов в директории и во всех вложенных папках.
        quantityFilesInDir();
    }

    private void quantityFilesInDir(){
        File file = new File("E:\\ОБУЧЕНИЕ\\lesson-18-IO-streams-binnary-data-serialization");
        int q = file.listFiles().length;
        System.out.println("Количество файлов в корневой папке проектов: " + q);
    }

}
