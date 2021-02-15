package project.view;

import project.AppGlobalState;
import project.controller.Controller;
import project.controller.IController;
import project.model.IWeatherRepository;
import project.model.SQLiteWeatherRepository;
import project.model.entity.Weather;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface implements IUserInterface {

    IController controller = new Controller();
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository();

    @Override
    public void showMenu() {

        while (true) {
            try{
                System.out.println("\nВведите \n1 - для выбора города\n2 - для вызова архива погоды\n3 - для выхода");
                Scanner scanner = new Scanner(System.in);

                int selectedCommand = scanner.nextInt();
                switch (selectedCommand) {
                    case 1: {
                        System.out.println("Введите название города на английском языке");

                        String userResponse = scanner.next();

                        try{
                            controller.onCityInput(userResponse);
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }

                        System.out.println("\nВведите \n1 - для получения погоды на текущий день\n2 - для получения погоды на 5 дней");

                        int selectedCommand2 = scanner.nextInt();

                        try {
                            controller.onCommandChosen(selectedCommand2);
                        } catch (IOException e) {
                            e.printStackTrace();
                            continue;
                        }
                        break;
                    }
                    case 2: {
                        List<Weather> allData = weatherRepository.getAllData();
                        for (Weather w : allData) {
                            System.out.printf("В городе %s на дату %s ожидается %s, температура - %sС.\n", w.getCity(),
                                    w.getLocalDate(), w.getWeatherText(), w.getTemperature());
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Завершаю работу...");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Неверный ввод\n");
                    }
                }
            } catch (Exception e) {
                System.out.println("Неверный ввод\n");
            }
        }
    }
}
