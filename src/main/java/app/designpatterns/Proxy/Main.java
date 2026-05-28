package app.designpatterns.Proxy;

public class Main {
    public static void main(String[] args) {

        SecureService service = new SecureService();
        User admin = new User("Alice", "admin");
        User normal = new User("Bob", "user");

      //  AccessController.invokeIfAuthorized(service, admin, "deleteAllUsers");
      //  AccessController.invokeIfAuthorized(service, normal, "deleteAllUsers");
      //  AccessController.invokeIfAuthorized(service, normal, "viewProfile");
      //  AccessController.invokeIfAuthorized(service, normal, "help");

        Service adminProxy = new SecureServiceProxy(service, admin);
        Service userProxy = new SecureServiceProxy(service, normal);

        adminProxy.deleteAllUsers(); // Tilladt
        userProxy.deleteAllUsers(); // ikke tilladt da det ikke er en admin
        userProxy.viewProfile();
        userProxy.help();
    }
}
