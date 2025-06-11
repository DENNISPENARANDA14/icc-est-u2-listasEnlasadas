package controller;
import model.Contact;
import model.LinkedList;
import model.Node;

public class ContactManager {
    private LinkedList<Contact<?, ?>> contacts = new LinkedList<>();

    public void addContact(Contact<?, ?> contact) {
        contacts.appendToTail(contact);
    }

    public Contact<?, ?> findContactByName(String name) {
        Node<Contact<?, ?>> current = contacts.getHead();
        while (current != null) {
            if (current.getValue().getName().equals(name)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean deleteContactByName(String name) {
        Node<Contact<?, ?>> current = contacts.getHead();
        while (current != null) {
            if (current.getValue().getName().equals(name)) {
                return contacts.deleteByValue(current.getValue());
            }
            current = current.getNext();
        }
        return false;
    }

    public void printList() {
        contacts.print();
    }
}