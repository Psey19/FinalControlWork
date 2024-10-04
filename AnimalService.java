package Service;

import Model.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private List<Animal> animalList;
    private List<Pet> petList;
    private List<Pack_Animal> packAnimalList;

    public AnimalService() {
        this.animalList = new ArrayList<>();
        this.petList = new ArrayList<>();
        this.packAnimalList = new ArrayList<>();
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public List<Pack_Animal> getPackAnimalList() {
        return packAnimalList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void create(String name, String dateBirth, String commands, Type type) {
        int id = getAnimal_Id();
        if (type == Type.Cat) {
            Cat cat = new Cat(id, name, dateBirth, commands);
            addAnimalToList(cat);
        }
        if (type == Type.Dog) {
            Dog dog = new Dog(id, name, dateBirth, commands);
            addAnimalToList(dog);
        }
        if (type == Type.Hamster) {
            Hamster hamster = new Hamster(id, name, dateBirth, commands);
            addAnimalToList(hamster);
        }
        if (type == Type.Horse) {
            Horse horse = new Horse(id, name, dateBirth, commands);
            addAnimalToList(horse);
        }
        if (type == Type.Camel) {
            Camel camel = new Camel(id, name, dateBirth, commands);
            addAnimalToList(camel);
        }
        if (type == Type.Donkey) {
            Donkey donkey = new Donkey(id, name, dateBirth, commands);
            addAnimalToList(donkey);
        }
    }

    private int getAnimal_Id() {
        int id = 0;
        for (Animal animal : animalList) {
                id = animal.getAnimal_Id();
        }
        return ++id;
    }

    private void addAnimalToList(Animal animal){
        animalList.add(animal);
        if (animal.getSpecies() == Species.Pet) {
            petList.add((Pet)animal);
        }
        if (animal.getSpecies() == Species.Pack_Animal) {
            packAnimalList.add((Pack_Animal)animal);
        }
    }

    public Animal getAnimalFromName(List<Animal> animalList, String name, String dateBirth){
        Animal foundedAnimal = null;
        for (Animal animal : animalList){
            if(animal.getName().equals(name) && animal.getDateBirth().equals(dateBirth)){
                foundedAnimal = animal;
            }
        }
        return foundedAnimal;
    }

    public void getAnimalFromDateBirth(List<Animal> animalList, String dateBirth){
        List<Animal> foundAnimal = new ArrayList<>();
        for (Animal animal : animalList){
            if(animal.getDateBirth().equals(dateBirth)){
                foundAnimal.add(animal);
                System.out.println(animal);
            }
        }
        if(foundAnimal.isEmpty())
            System.out.println("По вашему запросу животных нет");
    }

    public void getCommandsFromName(List<Animal> animalList, String name, String dateBirth){
        List<Animal> foundAnimal1 = new ArrayList<>();
        for (Animal animal : animalList){
            if(animal.getName().equals(name) && animal.getDateBirth().equals(dateBirth)){
                foundAnimal1.add(animal);
            }
        }
        if(foundAnimal1.isEmpty()) {
            System.out.println("По вашему запросу животных нет");
        }
        else{
            System.out.println("----------- Команды, которые знает этот питомец: -----------");
            for (Animal animal : foundAnimal1) {
                System.out.println(animal.getCommands());
            }
        }
    }


}
