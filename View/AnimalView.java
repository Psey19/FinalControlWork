package View;


import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalView {
    Scanner sc = new Scanner(System.in);


    public void printAnimals(List<Animal> animallist) {
        for (Animal animal : animallist) {
            System.out.println(animal);
        }
    }

    public void printAnimalCommands(Animal animal){
        System.out.println(animal.getCommands());
    }

    public void printPets(List<Pet> petlist) {
        for (Pet pet : petlist) {
            System.out.println(pet);
        }
    }

    public void printPackAnimals(List<Pack_Animal> packAnimallist) {
        for (Pack_Animal packAnimal : packAnimallist) {
            System.out.println(packAnimal);
        }
    }

    public void exit() {
            System.out.println("Всего вам доброго!");
    }

    public String mainMenu(){
        System.out.println("----------------- Реестр животных -----------------");
        System.out.println("Выберите нужную вам процедуру: ");
        System.out.println("1 - Добавить животное в реестр");
        System.out.println("2 - Узнать список команд, которые выполняет животное");
        System.out.println("3 - Обучение животного новым командам");
        System.out.println("4 - Показать животных");
        System.out.println("5 - Cчётчик животных");
        System.out.println("6 - Выход");
        return sc.nextLine();
    }

    public String addAnimalMenu(){
        System.out.println("----------- Добавление животного в реестр -----------");
        System.out.println("Выберите вид животного: ");
        System.out.println("1 - Домашнее");
        System.out.println("2 - Вьючное");
        System.out.println("3 - Вернуться в главное меню");
        return sc.nextLine();
    }

    public String addAnimalPetMenu(){
        System.out.println("----------- Добавление домашнего животного -----------");
        System.out.println("Выберите тип животного: ");
        System.out.println("1 - Кошка");
        System.out.println("2 - Собака");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Вернуться назад");
        System.out.println("5 - Вернуться в главное меню");
        return sc.nextLine();
    }
    public String addAnimalPackMenu(){
        System.out.println("----------- Добавление вьючного животного -----------");
        System.out.println("Выберите тип животного: ");
        System.out.println("1 - Лошадь");
        System.out.println("2 - Верблюд");
        System.out.println("3 - Осёл");
        System.out.println("4 - Вернуться назад");
        System.out.println("5 - Вернуться в главное меню");
        return sc.nextLine();
    }

    public String showAnimalMenu(){
        System.out.println("----------- Показать животных -----------");
        System.out.println("Выберите каких животных хотите посмотреть: ");
        System.out.println("1 - Все животные в реестре");
        System.out.println("2 - Все домашние животные");
        System.out.println("3 - Все вьючные животные");
        System.out.println("4 - Найти животное по дате рождения");
        System.out.println("5 - Вернуться в главное меню");
        return sc.nextLine();
    }
    public String moreCommandMenu(){
        System.out.println("1 - Добавить еще одну команду");
        System.out.println("2 - Вернуться в главное меню");
        return sc.nextLine();
    }

    public String addName(){
        System.out.println("Введите имя питомца: ");
        return sc.nextLine();
    }
    public String addDateBirth(){
        System.out.println("Введите дату рождения питомца в формате (dd.MM.yyyy): ");
        return sc.nextLine();
    }
    public String addCommand(){
        System.out.println("Введите новую команду: ");
        return sc.nextLine();
    }





    public void addCat(){
        System.out.println("----------- Добавление кошки -----------");
    }
    public void addDog(){
        System.out.println("----------- Добавление собаки -----------");
    }
    public void addHamster(){
        System.out.println("----------- Добавление хомяка -----------");
    }
    public void addHorse(){
        System.out.println("----------- Добавление лошади -----------");
    }
    public void addCamel(){
        System.out.println("----------- Добавление верблюда -----------");
    }
    public void addDonkey(){
        System.out.println("----------- Добавление осла -----------");
    }
    public void animalAdded(){
        System.out.println("Питомец успешно добавлен в наш реестр");
    }
    public void showAnimalCommands(){
        System.out.println("----------- Узнать список команд, которые выполняет животное -----------");
    }
    public void teachAnimalCommands(){
        System.out.println("----------- Обучить животное новой команде -----------");
    }
    public void animalNotFounded(){
        System.out.println("По вашему запросу животных нет");
    }
    public void animalOldCommands(){
        System.out.println("----------- Команды, которые знает этот питомец: -----------");
    }
    public void animalNewCommands(){
        System.out.println("----------- Команды, которые теперь знает этот питомец: -----------");
    }
    public void showCounter(){
        System.out.println("----------- Количество добавленных в реестр животных: -----------");
    }



}
