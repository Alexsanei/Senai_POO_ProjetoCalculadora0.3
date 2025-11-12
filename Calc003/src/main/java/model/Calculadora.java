/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

/**
 *
 * @author Alex
 */
public class Calculadora {

    public double dividir(double num1,double num2) throws ArithmeticException{
        if(num2 == 0){
            throw new ArithmeticException("Nao e possivel dividir por zero");
        }
        return num1 / num2;
    }
    
    public double somar(double num1,double num2) {
        return num1 + num2;
        }
        
    public double subtrair(double num1,double num2) throws ArithmeticException{
        if(num1 < num2){
            throw new ArithmeticException("Nao e possivel subtrair numero");
        }
        return num1 - num2;
    }

    public double multiplicar(double num1,double num2) {
        return num1 * num2;
    }
        
}
