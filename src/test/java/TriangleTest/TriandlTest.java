package TriangleTest;


import CrmTest.AutoTest.Test01;
import org.junit.jupiter.api.*;
import triangle.Triangle;
//важный импорт, указать, что в импорте должен быть именно он

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TriandlTest {
    Triangle triangle = new Triangle(10,10,10);

    @Test
    @DisplayName("Проверяем, что такой треугольник существует")

    void triandleCorrect(){
        boolean check = triangle.triangleCheck();

        Assertions.assertTrue(check);


    }
    //проверяем, что рассчет площади треугольника верен
    @Test
    @DisplayName("Проверяем, что рассчет площади треугольника верен")

     void triandleTestArea(){
        Assumptions.assumeTrue(triangle.triangleCheck()==true);
        double squer = triangle.triangleArea();

        Assertions.assertTrue(squer == 43.30127018922193);


    }
    @Test
    @DisplayName("Запускаем автотесты")
    void auto() {
        Test01 aa = new Test01();
        aa.test01();
        aa.test02();




    }




}
