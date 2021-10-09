package Adbistju.system;

import Adbistju.system.Service.Cache;
import Adbistju.system.Service.CustomConnectionMysql;

public class Main {

    public static void main(String[] args) {
        CustomConnectionMysql.createConnection();
        FigureMapper figureMapper = new FigureMapper(CustomConnectionMysql.getConnection());

        System.out.println(figureMapper.findById(1));

        System.out.println(figureMapper.findById(2));

        System.out.println(figureMapper.findById(3));

        Figure f1 = new Figure();

        f1.setAngle(0);
        f1.setHeight(6);
        f1.setWidth(4);

        figureMapper.insertFigure(f1);

        System.out.println(figureMapper.findById(4));

        Figure figureTest = new Figure();
        figureTest.setAngle(4);
        figureTest.setHeight(2);
        figureTest.setWidth(2);

        System.out.println("----------------");
        System.out.println(figureTest);

        System.out.println(Cache.get(figureTest.hashCode()));
        System.out.println("----------------");
    }
}

