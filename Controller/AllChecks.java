package Controller;

import java.util.List;
import java.util.regex.Pattern;
import Exception.*;
import Model.Animal;
import Model.Type;


public class AllChecks {
    public void checkDate(String dataBirth) throws BirthDateException {
        String[] date = dataBirth.split("\\.");

        if (date.length != 3) {
            throw new BirthDateException("Вы забыли поставить разделитель '.'");
        }

        String day = date[0];
        String month = date[1];
        String year = date[2];
        int dayNumber;
        int monthNumber;
        int yearNumber;

        boolean isDay = day.matches("-?\\d+");
        boolean isMonth = month.matches("-?\\d+");
        boolean isYear = year.matches("-?\\d+");

        if (isDay && isMonth && isYear) {
            dayNumber = Integer.parseInt(day);
            monthNumber = Integer.parseInt(month);
            yearNumber = Integer.parseInt(year);
        } else {
            throw new BirthDateException("Вы ввели не числовое значение");
        }
        if (day.length() != 2) {
            throw new BirthDateException("День рождения необходимо указать в формате 'dd'");
        } else if (month.length() != 2) {
            throw new BirthDateException("Месяц рождения необходимо указать в формате 'MM'");
        } else if (year.length() != 4) {
            throw new BirthDateException("Год рождения необходимо указать в формате 'yyyy'");
        } else if (dayNumber < 1) {
            throw new BirthDateException("День не может быть меньше 1 числа");
        } else if (dayNumber > 31) {
            throw new BirthDateException("День не может быть больше 31 числа");
        } else if (monthNumber < 1) {
            throw new BirthDateException("Месяц не может быть меньше 1");
        } else if (monthNumber > 12) {
            throw new BirthDateException("Месяц не может быть больше 12");
        } else if (monthNumber == 02 && dayNumber == 29) {
            if (yearNumber % 4 != 0 || yearNumber % 400 != 0 && yearNumber % 100 == 0) {
                throw new BirthDateException("В феврале этого года 28 дней");
            }
        } else if (monthNumber == 02 && dayNumber > 28) {
            throw new BirthDateException("В феврале нет столько дней");
        } else if (dayNumber > 30) {
            if (monthNumber == 04 || monthNumber == 06 || monthNumber == 9 || monthNumber == 11) {
                throw new BirthDateException("В этом месяце 30 дней");
            }
        }
    }
    public boolean checkWord(String word) {
        char firstChar = word.charAt(0);
        String firstPartWord = Character.toString(firstChar);
        String secondPartWord = "";
        for (int i = 1; i < word.length(); i++) {
            secondPartWord += word.charAt(i);
        }
        boolean isWord = Pattern.matches("[A-Z]+", firstPartWord)
                && Pattern.matches("[a-z ]+", secondPartWord) ||
                Pattern.matches("[А-Я]+", firstPartWord)
                        && Pattern.matches("[а-я ]+", secondPartWord);
        return isWord;
    }


    public boolean checkLanguage(String name, String commands){
        boolean isLanguage = Pattern.matches("[a-zA-Z]+", name)
                && Pattern.matches("[a-zA-Z ]+", commands) ||
                Pattern.matches("[а-яА-Я]+", name) &&
                        Pattern.matches("[а-яА-Я ]+", commands);
        return isLanguage;
    }

    public void checkLanguageWord(String name, String commands) throws LanguageWordException {
        if (!checkLanguage(name, commands)){
            throw new LanguageWordException("Языки ввода имени и команды отличаются");
        }
    }

    public void checkName(String name) throws WordException {
        if(!checkWord(name)){
            throw new WordException("Неверный формат имени");
        }
    }

    public void checkCommands(String commands) throws WordException {
        if(!checkWord(commands)){
            throw new WordException("Неверный формат команды");
        }
    }

    public void checkChoice(String choice, int a) throws ChoiceException {
        boolean isChoice = choice.matches("-?\\d+");
        if (!isChoice) {
            throw new ChoiceException("Вы ввели не число, повторите ввод операции");
        }
        else if (Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > a){
            throw new ChoiceException("Такой операции в списке нет, повторите ввод операции");
        }
    }
    public void checkRepeat(List<Animal> animalList, String name, String dateBirth, Type type) throws RepeatException{
        for(Animal animal: animalList){
            if(animal.getName().equals(name) && animal.getDateBirth().equals(dateBirth)
                    && animal.getType().equals(type)){
                throw new RepeatException("Это животное уже есть в реестре");
            }
        }
    }



}

