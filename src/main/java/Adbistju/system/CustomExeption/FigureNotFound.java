package Adbistju.system.CustomExeption;

public class FigureNotFound extends RuntimeException{

    private int id;
    private String message;

    public FigureNotFound(String message, int id){
        super(message);
        this.id=id;
    }
}
