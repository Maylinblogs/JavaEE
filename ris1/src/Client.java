import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
// Получаем стаб регистратора с хоста, определенного в командной строке
// если в командной строке хост не указывается, то он считается как localhost
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
// получаем стаб удаленного объекта от регистратора сервера
            Hello stub = (Hello) registry.lookup("Hello");
            Scanner in=new Scanner(System.in);
            System.out.println("Enter first number");
            int a=in.nextInt();
            System.out.println("Enter second number");
            int b=in.nextInt();
            String response = stub.sayHello(a,b);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
