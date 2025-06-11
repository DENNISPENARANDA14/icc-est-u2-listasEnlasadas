package controller;
import model.*;
import view.ConsoleView;

public class MenuController {
    private ContactManager contactManager = new ContactManager();
    private ConsoleView consoleView = new ConsoleView();

    public void showMenu() {
        boolean running = true;
        while (running) {
            consoleView.displayMenu();
            String option = consoleView.getInput("Seleccione una opción: ");

            switch (option) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    contactManager.printList();
                    break;
                case "5":
                    running = false;
                    consoleView.showMessage("Saliendo del programa.");
                    break;
                default:
                    consoleView.showMessage("Opción inválida.");
            }
        }
    }

    private void addContact() {
        String name = consoleView.getInput("Nombre: ");
        String phone = consoleView.getInput("Teléfono: ");
        contactManager.addContact(new Contact<>(name, phone));
        consoleView.showMessage("Contacto agregado.");
    }

    private void findContact() {
        String name = consoleView.getInput("Nombre a buscar: ");
        Contact<?, ?> contact = contactManager.findContactByName(name);
        if (contact != null) {
            consoleView.showMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.showMessage("No encontrado.");
        }
    }

    private void deleteContact() {
        String name = consoleView.getInput("Nombre a eliminar: ");
        boolean eliminado = contactManager.deleteContactByName(name);
        consoleView.showMessage(eliminado ? "Contacto eliminado." : "No se encontró el contacto.");
    }
}