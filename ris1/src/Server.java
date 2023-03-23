import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import java.rmi.server.UnicastRemoteObject;


public class Server implements Hello {
    public Server() {}
    // реализация интерфейса
    public String sayHello(int a,int b) {


        int nok=(a / gcd(a,b) * b);
        String str1 = Integer.toString(nok);

        return str1;
    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    public static void main(String args[]) {
        try {
// создаем и экспортируем удаленный объект
            Server obj = new Server();
            Hello stub =(Hello) UnicastRemoteObject.exportObject(obj, 0);
// Регистрируем удаленный объект в RMI-регистраторе под именем
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Hello", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
