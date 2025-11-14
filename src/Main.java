import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Conversor de Monedas VIA - ONE G9");

        Scanner teclado = new Scanner(System.in);
        ExchangeRateClient client = new ExchangeRateClient();

        int opcion = 0;

        while (true) {
            System.out.println("\n=== MENÚ CONVERSOR VIA ===");
            System.out.println("1) USD -> ARS");
            System.out.println("2) ARS -> USD");
            System.out.println("3) USD -> BRL");
            System.out.println("4) BRL -> USD");
            System.out.println("5) USD -> COP");
            System.out.println("6) COP -> USD");
            System.out.println("7) Salir");
            System.out.print("Elija una opción: ");

            opcion = teclado.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el Conversor VIA · ONE G9");
                break;
            }

            System.out.print("Ingrese monto: ");
            double monto = teclado.nextDouble();

            try {
                double tasa;
                double resultado;

                switch (opcion) {
                    case 1 -> {
                        tasa = client.getRate("USD", "ARS");
                        resultado = monto * tasa;
                        System.out.println(monto + " USD = " + resultado + " ARS");
                    }
                    case 2 -> {
                        tasa = client.getRate("ARS", "USD");
                        resultado = monto * tasa;
                        System.out.println(monto + " ARS = " + resultado + " USD");
                    }
                    case 3 -> {
                        tasa = client.getRate("USD", "BRL");
                        resultado = monto * tasa;
                        System.out.println(monto + " USD = " + resultado + " BRL");
                    }
                    case 4 -> {
                        tasa = client.getRate("BRL", "USD");
                        resultado = monto * tasa;
                        System.out.println(monto + " BRL = " + resultado + " USD");
                    }
                    case 5 -> {
                        tasa = client.getRate("USD", "COP");
                        resultado = monto * tasa;
                        System.out.println(monto + " USD = " + resultado + " COP");
                    }
                    case 6 -> {
                        tasa = client.getRate("COP", "USD");
                        resultado = monto * tasa;
                        System.out.println(monto + " COP = " + resultado + " USD");
                    }
                    default -> System.out.println("Opción inválida.");
                }

            } catch (RuntimeException e) {
                System.out.println("No pude obtener la cotización: " + e.getMessage());
            }
        }

        teclado.close();
    }
}
