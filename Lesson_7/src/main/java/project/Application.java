package project;

import project.view.IUserInterface;
import project.view.UserInterface;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        IUserInterface ui = new UserInterface();
        ui.showMenu();
    }

}
