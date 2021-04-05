package triangle;
import org.apache.maven.surefire.booter.SystemUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static org.apache.commons.lang3.BooleanUtils.or;
//import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;
public class Triangle {
    int a;
    int b;
    int c;
   public Triangle(int i, int i1, int i2){
       this.a = i;
       this.b = i1;
       this.c = i2;
   }
   public boolean triangleCheck(){
       if ((a+b <= c) | (a+c <= b) | (b+c <= a)) {
           System.out.println("Такой треугольник не существует.");
           return (false);
       }
        else{
        if ((a != b) & (a != c) & (b != c)){
               System.out.println("Это разносторонний треугольник.");
               return (true);
           }

            else{
                if ((a == b) & (b == c)) {
                System.out.println("Это равносторонний треугольник.");
                return (true);
                }
                else {
                System.out.println("Это равнобедренный треугольник.");
                return (true);
                }
            }
        }

    }
   public double triangleArea(){
       double p;
       p = (a+b+c)/2;
       double s;
       s = sqrt(p*(p-a)*(p-b)*(p-c));
       System.out.println("Площадь треугольника: " + s);
       return(s);
   }

}
