import exceptions.InvalidDataException;
import managers.*;
import managers.FileManager;
import commands.*;

import java.util.Scanner;

import java.io.IOException;

/**
 * Точка входа приложения.
 * Загружает коллекцию из CSV-файла (аргумент командной строки), регистрирует команды и запускает цикл ввода команд.
 */
public class Main {

    /**
     * Инициализирует менеджеры, загружает коллекцию из файла (args[0]), регистрирует команды и входит в цикл чтения команд с консоли.
     *
     * @param args путь к CSV-файлу с начальной коллекцией; при отсутствии аргумента программа завершается с сообщением
     */
    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(collectionManager);
        if (args.length != 0) {
            try {
                fileManager.addFromFile(args[0]);
                collectionManager.update_ID();
                System.out.println("Коллекция успешно загружена!");
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            } catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Файл не обнаружен");
            System.exit(1);
        }

        System.out.println("Для сводки по командам введите : help");
        commandManager.addCommand(new Help(collectionManager));
        commandManager.addCommand(new Info(collectionManager));
        commandManager.addCommand(new Show(collectionManager));
        commandManager.addCommand(new Insert(collectionManager));
        commandManager.addCommand(new Update(collectionManager));
        commandManager.addCommand(new RemoveKey(collectionManager));
        commandManager.addCommand(new Clear(collectionManager));
        commandManager.addCommand(new Save(fileManager, args[0]));
        commandManager.addCommand(new ExecuteScript(commandManager));
        commandManager.addCommand(new Exit());
        commandManager.addCommand(new RemoveLower(collectionManager));
        commandManager.addCommand(new History(commandManager));
        commandManager.addCommand(new RemoveGreaterKey(collectionManager));
        commandManager.addCommand(new RemoveAllByMinutesOfWaiting(collectionManager));
        commandManager.addCommand(new PrintAscending(collectionManager));
        commandManager.addCommand(new PrintFieldAscendingImpactSpeed(collectionManager));


        Scanner scanner = UserScanner.getUserScanner();
        while (true) {
            String CommandToSplit = scanner.nextLine().trim() + " ";
            String[] command = CommandToSplit.split(" ", 2);
            commandManager.execute(command[0], command[1].trim());
        }
    }

}

