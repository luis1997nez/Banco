
import java.util.Scanner;

/*ADMINISTRACIÓN (Apartado para crear usuario)
	Crear usuario
		Nombre completo
		Nip
		Numero de tarjeta
		Fondos iniciales

CAJERO ()
	Validacion de tajeta con NIP
	Visualizacion de fondos
	Retiro de fondos
		Validación de fondos (Verificar que los fondos sean suficientes)
	Deposito de dinero (Sumar dinero a la cantidad actualidad)
	¿Deseas realizar otra transacción?		
	Cerrar sesión */
		


public class Banco {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        persona p = new persona();
        administracion conexion = new administracion ();
        Scanner pregunta = new Scanner(System.in);
        
        int opcion = 0;
        System.out.println("¿En que desea trabajar?\n\nPresione 1 para administrar\nPresione 2 para ser cajero\n");
        opcion = pregunta.nextInt();
        
        if(opcion == 1){
            System.out.println("\n\n-ADMINISTRACIÓN-\n\nAlta de usuario");
            
            String dato = " ";
                int num = 0;
                Scanner datos = new Scanner(System.in);
        
                System.out.print("id: ");
                num = datos.nextInt();
                p.setId(num);
        
                System.out.print("Nombre: ");
                dato = datos.next();
                p.setNombre(dato);
                
                System.out.print("ApellidoP: ");
                dato = datos.next();
                p.setApellidoP(dato);
        
                System.out.print("Apellido M: ");
                dato = datos.next();
                p.setApellidoM(dato);
            
                System.out.print("NIP: ");
                num = datos.nextInt();
                p.setNip(num);
                
                System.out.print("Tarjeta: ");
                num = datos.nextInt();
                p.setNumTarjeta(num);
                
                System.out.print("Fondos: ");
                num = datos.nextInt();
                p.setFondos(num);
        
                conexion.insertarRegistro(p);
            
        }else{
           /* p.setNumTarjeta(12345);
            p=conexion.seleccionarPersona(p);
            System.out.print(p);*/
            
            System.out.println("\n\n-CAJERO-");
            
            int num = 0;
            int num2 = 0;
            int com = 0;
            int cont = 1;
            Scanner datos = new Scanner(System.in);
        
            System.out.print("\nNumero de tarjeta: ");
            num = datos.nextInt();
            //num2 = datos.nextInt();
            
            p.setNumTarjeta(num);
            p=conexion.seleccionarPersona(p);
            com = p.getNip();
            
            System.out.print("Ingrese el NIP: ");
            num2 = datos.nextInt();
            
            if(num2 == com){
                int num3;
                num3 = num;
                p.setNumTarjeta(num3);
       
                while(cont == 1){
                    int menu = 0;
                    System.out.println("\nBienvenido\n\n1-Ver fondos\n2-Retirar fondos\n3-Depositar\n4-Salir");
                    menu = datos.nextInt();
                               
                    switch(menu){

                        case 1:
                            System.out.println("\n\nUsted selecciono Ver fondos");
                            //System.out.println("\n"+num3+"\n");
                            //p.setNumTarjeta(num3);
                            p=conexion.seleccionarPersona(p);
                            float fondos = 0;
                            fondos = p.getFondos();
                            
                            System.out.println("Saldo actual: " + fondos);
                        break;
                        
                        case 2:
                            System.out.println("\n\nUsted selecciono Retiro de fondos");
                            //System.out.println("\n"+num3+"\n");
                            float retiro = 0;
                            float retiro2 = 0;
                            float resul = 0;
                            
                            System.out.println("¿Cuando desea retirar?");
                            retiro = datos.nextFloat();
                        
                            //p.setNumTarjeta(num3);
                            p=conexion.seleccionarPersona(p);
                            retiro2 = p.getFondos();
                        
                            if(retiro <= retiro2){
                            
                                resul = retiro2 - retiro;
                                conexion.actualizacionPersona(num3, resul);
                            
                            }else{
                                System.out.println("\nFondos insuficientes");
                            }
                                    
                        break;
                        
                        case 3:
                            System.out.println("\n\nUsted selecciono Deposito");
                        
                            float deposito = 0;
                            float deposito2 = 0;
                            float resul2 = 0;
                            System.out.println("\nCuanto desea depositar?");
                            deposito = datos.nextFloat();
                        
                            //p.setNumTarjeta(num3);
                            p = conexion.seleccionarPersona(p);
                            deposito2 = p.getFondos();
                        
                            resul2 = deposito + deposito2;
                        
                            conexion.actualizacionPersona(num3, resul2);
                        
                        
                        break;
                            
                        case 4:
                        
                            System.exit(0);
                            
                        break;
                
                        default:
                            System.out.println("\n\nError, Ninguna tecla esta en la opciones");
                        break;
                    }
                
                    System.out.println("\n\n¿Desea realizar otra transacción?\n\n1 = Si\n0 = No");
                    cont = datos.nextInt();
                    
                    /*if(cont == 0){
                        conexion.cerrarRegistro(p);
                    }*/
                    //p=conexion.seleccionarPersona(p, cont);
            
                }
                              
            }else{
                
                System.out.println("\nNIP incorrecto\n");
            
            }
                     
        }
        
    }
    
}