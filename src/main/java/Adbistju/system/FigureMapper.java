package Adbistju.system;

import Adbistju.system.CustomExeption.FigureNotFound;
import Adbistju.system.Service.Cache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FigureMapper {

    private final Connection connection;


    public FigureMapper(Connection connection) {
        this.connection = connection;
        findAll();
    }

    public Figure findById(int idFigure){
        Figure cache = Cache.getById(idFigure);
        if(cache != null){
            System.out.println("database not use");
            return cache;
        }
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT id, area, width, height, angle FROM figures WHERE id = ?");
            statement.setInt(1,idFigure);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Figure figure = new Figure();
                figure.setId(resultSet.getInt(1));
                figure.setAngle(resultSet.getInt(5));
                //figure.setSquare(resultSet.getFloat(2));
                figure.setWidth(resultSet.getFloat(3));
                figure.setHeight(resultSet.getFloat(4));
                return figure;
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        } catch (FigureNotFound e){
            throw new FigureNotFound("Not found figure by id ="+ idFigure, idFigure);
        }
        return new Figure();
    }

    public void insertFigure(Figure figure){
        Figure test = Cache.get(figure.hashCode());
        if(test != null) {
            System.out.println("this object is insert!");
            return;
        }
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT MAX(`id`) FROM `figures`");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                figure.setId(resultSet.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(figure.getSquare());
        System.out.println(figure.getAngle());
        System.out.println(figure.getId());
        try {
            statement = null;
            statement = connection.prepareStatement("INSERT INTO `figures` (`id`, `area`, `width`, `height`, `angle`) VALUES ('"
                    +(figure.getId()+1)+"','"
                    +figure.getSquare()+"', '"
                    +figure.getWidth()+"', '"
                    +figure.getHeight()+"', '"
                    +figure.getAngle()+"');");

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void findAll(){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT id, area, width, height, angle FROM figures LIMIT 10");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Figure figure = new Figure();
                figure.setId(resultSet.getInt(1));
                figure.setAngle(resultSet.getInt(5));
                //figure.setSquare(resultSet.getFloat(2));
                figure.setWidth(resultSet.getFloat(3));
                figure.setHeight(resultSet.getFloat(4));
                Cache.put(figure.hashCode(),figure);
                System.out.println("cache!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
