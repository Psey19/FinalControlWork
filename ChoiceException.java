package Exception;

public class ChoiceException extends Exception{
    public ChoiceException(String message){
        super("Ошибка ввода выбора операции (" + message + ")");
    }
}
