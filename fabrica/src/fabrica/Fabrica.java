/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Fabrica {
public static void mostrar_ventas(int venta[][])
{
    for (int i = 0; i < 5; i++) {
        System.out.println("departamento "+(i+1)+" :");
        System.out.format("%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s", "ene","feb","mar","abr","may","jun", "jul", "ago", "sep", "oct", "nov","dic" );
        System.out.println(" ");
        System.out.format("%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s%4s", venta[i][0],venta[i][1],venta[i][2],venta[i][3],venta[i][4],venta[i][5], venta[i][6], venta[i][7], venta[i][8], venta[i][9],venta[i][10], venta[i][11] );
        System.out.println(" ");
    }
}
public static int calcular_ventas_mensuales(int venta[][], int mes)
{int venta_mensual=0;
    
        for (int j = 0; j < 5; j++) {
           venta_mensual+=venta[j][mes]; 
        }
        
       
    
return venta_mensual;
}
public static void mostrar_ventas_anuales(int venta[][])
{int venta_anual=0;
    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 5; j++) {
           venta_anual+=venta[j][i]; 
        }
        }
     System.out.println("las ventas en el anual es: "+venta_anual);
}
public static void mostrar_mayor_julio(int venta[][])
{int dto=0;
int cantidad=venta[0][6];
    for (int i = 1; i < 5; i++) {
        if(venta[i][6]>cantidad)
        {
        dto=i;
        cantidad=venta[i][6];
        }
    }
     System.out.println("el depto que mas vendio en julio es: "+(dto+1)+" vendio: "+cantidad+" unidades");
}
public static void mostrar_mejor_mes(int venta[][],int dto)
{int mes=0;
dto=dto-1;
int cantidad=venta[dto][0];
    for (int i = 1; i < 12; i++) {
        if(venta[dto][i]>cantidad)
        {
        mes=i+1;
        cantidad=venta[dto][i];
        }
    }
     System.out.println("el depto vendio mas en el mes : "+mes+" vendio: "+cantidad+" unidades");
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int ventas_dto[][]=new int[5][12];
    int opcion=0;
    int dto;
        for (int i = 0; i < 5; i++) 
            for (int j = 0; j < 12; j++) 
                  ventas_dto[i][j]=(int) (Math.random() * 100);
         while(opcion!=6){   
        System.out.println("ingrese la accion que desee realizar: ");
        System.out.println("(1)mostrar las ventas");
        System.out.println("(2) departamento con mayor volumen de ventas en julio");
        System.out.println("(3)ventas mensuales");
        System.out.println("(4) ventas anuales");
        System.out.println("(5) mejor mes de venta para un departamento");
        System.out.println("(6) salir");
         Scanner lectura=new Scanner(System.in);
         opcion=lectura.nextInt();
        switch(opcion){
            case 1:
        System.out.println("las ventas de los departamentos son:");
        mostrar_ventas(ventas_dto);
        break;
            case 2:
         mostrar_mayor_julio(ventas_dto);
        break;
            case 3:
        System.out.println(" las ventas en el mes de julio son: "+calcular_ventas_mensuales(ventas_dto,8));
        break;
            case 4:
        mostrar_ventas_anuales(ventas_dto);
        break;        
            case 5:
                System.out.println("ingrese el departamento que requiere analizar");
               
                dto=lectura.nextInt();
        mostrar_mejor_mes(ventas_dto,dto);
        break;
        }
        }
    }
    
}
