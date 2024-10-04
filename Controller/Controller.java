package Controller;

import Model.*;
import Service.AnimalService;
import View.AnimalView;
import Exception.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Controller {
    private AnimalService service;
    private AnimalView view;
    private AllChecks checks;
    private Counter count;
    private String name;
    private String dateBirth;
    private String command;
    private String fileName;

    public Controller() {
        this.service = new AnimalService();;
        this.view = new AnimalView();
        this.checks = new AllChecks();
        this.count = new Counter();
        this.fileName = "Animal_Registry.txt";
    }

    public void createFile() {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file, false);
            for (Animal animal: service.getAnimalList()){
                String newAnimal = "<Id: " + animal.getAnimal_Id() + ">, " + "<Species: " + animal.getSpeciesToString()
                        + ">, " + "<Type: " + animal.getTypeToString() + ">, " + "<Name: " + animal.getName() + ">, "
                        + "<Date_Birth: " + animal.getDateBirth() + ">, " + "<Commands: " + animal.getCommands()+ ">";
                writer.write(newAnimal + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }

    public void createAnimalListFromFile(){
        try {
            if (Files.exists(Paths.get(fileName))) {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();
                while (line != null) {
                    service.create(getNameFromLine(line), getDateBirthFromLine(line),
                            getCommandsFromLine(line), getTypeFromLine(line));
                    count.add();
                    line = reader.readLine();
                }
                reader.close();
            }
            else {
                createFile();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }


    public void start() {
        createAnimalListFromFile();
        mainMenu();
    }

    private void checkChoiceMainMenu(String choice){
        try {
            checks.checkChoice(choice, 6);
            getMainMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            mainMenu();
        }
    }
    private void checkChoiceAddAnimalMenu(String choice){
        try {
            checks.checkChoice(choice, 3);
            getAddAnimalMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            addAnimalMenu();
        }
    }
    private void checkChoiceShowAnimalMenu(String choice){
        try {
            checks.checkChoice(choice, 5);
            getShowAnimalMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            showAnimalMenu();
        }
    }
    private void checkChoiceAddAnimalPetMenu(String choice){
        try {
            checks.checkChoice(choice, 5);
            getAddAnimalPetMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            addAnimalPetMenu();
        }
    }
    private void checkChoiceAddAnimalPackMenu(String choice){
        try {
            checks.checkChoice(choice, 5);
            getAddAnimalPackMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            addAnimalPackMenu();
        }
    }
    private void checkChoiceMoreCommandMenu(String choice){
        try {
            checks.checkChoice(choice, 2);
            getMoreCommandMenuOperation(choice);
        }catch (ChoiceException e){
            System.out.println(e.getMessage());
            moreCommandMenu();
        }
    }
    private void checkName(String name){
        try {
            checks.checkName(name);
            this.name = name;
        }catch (WordException e){
            System.out.println(e.getMessage());
            checkName(view.addName());
        }
    }
    private void checkDateBirth(String dateBirth){
        try {
            checks.checkDate(dateBirth);
            this.dateBirth = dateBirth;
        }catch (BirthDateException e){
            System.out.println(e.getMessage());
            checkDateBirth(view.addDateBirth());
        }
    }
    private void checkCommand(String command){
        try {
            checks.checkCommands(command);
            checks.checkLanguageWord(this.name, command);
            this.command = command;
        }catch (WordException e){
            System.out.println(e.getMessage());
            checkCommand(view.addCommand());
        }catch (LanguageWordException e){
            System.out.println(e.getMessage());
            checkCommand(view.addCommand());
        }
    }


    private void getMainMenuOperation(String choice){
        if (Integer.parseInt(choice) == 1) {
            addAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 2){
            showAnimalCommands();
            mainMenu();
        }
        else if (Integer.parseInt(choice) == 3) {
            teachNewCommand();
            mainMenu();
        }
        else if (Integer.parseInt(choice) == 4) {
            showAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 5) {
            view.showCounter();
            System.out.println(count.getCount());
            mainMenu();
        }
        else if (Integer.parseInt(choice) == 6)
            view.exit();
    }

    private void getAddAnimalMenuOperation(String choice){
        if (Integer.parseInt(choice) == 1) {
            addAnimalPetMenu();
        }
        else if (Integer.parseInt(choice) == 2) {
            addAnimalPackMenu();
        }
        else if (Integer.parseInt(choice) == 3) {
            mainMenu();
        }
    }

    private void getShowAnimalMenuOperation(String choice) {
        if (Integer.parseInt(choice) == 1) {
            printAnimals(service.getAnimalList());
            showAnimalMenu();
        } else if (Integer.parseInt(choice) == 2) {
            printPetAnimals(service.getPetList());
            showAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 3) {
            printPackAnimals(service.getPackAnimalList());
            showAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 4) {
            String dateBirthForSearch = view.addDateBirth();
            checkDateBirth(dateBirthForSearch);
            service.getAnimalFromDateBirth(service.getAnimalList(), dateBirthForSearch);
            showAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 5) {
            mainMenu();
        }
    }

    private void getAddAnimalPetMenuOperation(String choice){
        if (Integer.parseInt(choice) == 1) {
            view.addCat();
            addAnimal(Type.Cat);
        }
        else if (Integer.parseInt(choice) == 2){
            view.addDog();
            addAnimal(Type.Dog);
        }
        else if (Integer.parseInt(choice) == 3){
            view.addHamster();
            addAnimal(Type.Hamster);
        }
        else if (Integer.parseInt(choice) == 4) {
            addAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 5) {
            mainMenu();
        }
    }
    private void getAddAnimalPackMenuOperation(String choice){
        if (Integer.parseInt(choice) == 1) {
            view.addHorse();
            addAnimal(Type.Horse);
        }
        else if (Integer.parseInt(choice) == 2){
            view.addCamel();
            addAnimal(Type.Camel);
        }
        else if (Integer.parseInt(choice) == 3){
            view.addDonkey();
            addAnimal(Type.Donkey);
        }
        else if (Integer.parseInt(choice) == 4) {
            addAnimalMenu();
        }
        else if (Integer.parseInt(choice) == 5) {
            mainMenu();
        }
    }
    private void getMoreCommandMenuOperation(String choice){
        if (Integer.parseInt(choice) == 1) {
            addNewCommand();
            moreCommandMenu();
        }
        else if (Integer.parseInt(choice) == 2) {
            mainMenu();
        }
    }

    private void addAnimal(Type type) {
        try{
            checkName(view.addName());
            checkDateBirth(view.addDateBirth());
            checkCommand(view.addCommand());
            checks.checkRepeat(service.getAnimalList(), name, dateBirth, type);
            service.create(name, dateBirth, command, type);
            count.add();
            createFile();
            view.animalAdded();
            moreCommandMenu();
        } catch (RepeatException e) {
            System.out.println(e.getMessage());
            addAnimalMenu();
        }
    }

    private void mainMenu(){
        String choiceMainMenu = view.mainMenu();
        checkChoiceMainMenu(choiceMainMenu);
    }
    private void addAnimalMenu(){
        String choiceAddAnimalMenu = view.addAnimalMenu();
        checkChoiceAddAnimalMenu(choiceAddAnimalMenu);
    }
    private void showAnimalMenu(){
        String choiceShowAnimalMenu = view.showAnimalMenu();
        checkChoiceShowAnimalMenu(choiceShowAnimalMenu);
    }
    private void addAnimalPackMenu(){
        String choiceAddAnimalPackMenu = view.addAnimalPackMenu();
        checkChoiceAddAnimalPackMenu(choiceAddAnimalPackMenu);
    }
    private void addAnimalPetMenu(){
        String choiceAddAnimalPetMenu = view.addAnimalPetMenu();
        checkChoiceAddAnimalPetMenu(choiceAddAnimalPetMenu);
    }
    private void moreCommandMenu(){
        String choiceMoreCommandMenu = view.moreCommandMenu();
        checkChoiceMoreCommandMenu(choiceMoreCommandMenu);
    }
    private void showAnimalCommands(){
        view.showAnimalCommands();
        String nameForCommands = view.addName();
        checkName(nameForCommands);
        String dateBirthForCommands = view.addDateBirth();
        checkDateBirth(dateBirthForCommands);
        service.getCommandsFromName(service.getAnimalList(), nameForCommands, dateBirthForCommands);
    }
    private void teachNewCommand(){
        view.teachAnimalCommands();
        String nameForCommands = view.addName();
        checkName(nameForCommands);
        String dateBirthForCommands = view.addDateBirth();
        checkDateBirth(dateBirthForCommands);
        Animal foundedAnimal = service.getAnimalFromName(service.getAnimalList(), nameForCommands, dateBirthForCommands);
        if (foundedAnimal == null){
            view.animalNotFounded();
        }
        else{
            view.animalOldCommands();
            view.printAnimalCommands(foundedAnimal);
            String oldCommand = foundedAnimal.getCommands();
            String newCommand = view.addCommand();
            checkCommand(newCommand);
            newCommand = this.command;
            foundedAnimal.setCommands(newCommand + ", " + oldCommand);
            createFile();
            view.animalNewCommands();
            view.printAnimalCommands(foundedAnimal);
        }
    }
    private void addNewCommand(){
        Animal animal = service.getAnimalList().getLast();
        String oldCommand = animal.getCommands();
        String newCommand = view.addCommand();
        checkCommand(newCommand);
        newCommand = this.command;
        animal.setCommands(newCommand + ", " + oldCommand);
        createFile();
        view.animalAdded();
    }
    private void printAnimals(List<Animal> animalList){
        if(!animalList.isEmpty()) {
            view.printAnimals(animalList);
        }
        else{
            view.animalNotFounded();
        }
    }
    private void printPetAnimals(List<Pet> petList){
        if(!petList.isEmpty()) {
            view.printPets(petList);
        }
        else{
            view.animalNotFounded();
        }
    }
    private void printPackAnimals(List<Pack_Animal> packAnimalList){
        if(!packAnimalList.isEmpty()) {
            view.printPackAnimals(packAnimalList);
        }
        else{
            view.animalNotFounded();
        }
    }

    private String getNameFromLine(String animalIntoFile){
        String[] animalArray = animalIntoFile.split(">");
        String partName = animalArray[3];
        String[] animalPart = partName.split(": ");
        String name = animalPart[1];
        return name;
    }
    private String getDateBirthFromLine(String animalIntoFile){
        String[] animalArray = animalIntoFile.split(">");
        String partDateBirth = animalArray[4];
        String[] animalPart = partDateBirth.split(": ");
        String dateBirth = animalPart[1];
        return dateBirth;
    }
    private String getCommandsFromLine(String animalIntoFile){
        String[] animalArray = animalIntoFile.split(">");
        String partCommands = animalArray[5];
        String[] animalPart = partCommands.split(": ");
        String commands = animalPart[1];
        return commands;
    }
    private Type getTypeFromLine(String animalIntoFile){
        Type animalType = null;
        String[] animalArray = animalIntoFile.split(">");
        String partType = animalArray[2];
        String[] animalPart = partType.split(": ");
        String type = animalPart[1];
        if(type.equals("Cat"))
            animalType = Type.Cat;
        if(type.equals("Dog"))
            animalType = Type.Dog;
        if(type.equals("Hamster"))
            animalType = Type.Hamster;
        if(type.equals("Horse"))
            animalType = Type.Horse;
        if(type.equals("Camel"))
            animalType = Type.Camel;
        if(type.equals("Donkey"))
            animalType = Type.Donkey;
        return animalType;
    }

}









