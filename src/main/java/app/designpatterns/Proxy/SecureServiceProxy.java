package app.designpatterns.Proxy;

public class SecureServiceProxy implements Service{

    private final SecureService real;
    private final User user;

    public SecureServiceProxy(SecureService real, User user) {
        this.real = real;
        this.user = user;
    }

    @Override
    public void deleteAllUsers() {
        if (user.getRole().equals("admin")) {
            real.deleteAllUsers();
        } else {
            System.out.println("Adgang nægtet til deleteAllUsers for " + user.getName());
        }
    }

    @Override
    public void viewProfile() {
        if (user.getRole().equals("user")) {
            real.viewProfile();
        } else {
            System.out.println("Adgang nægtet til viewProfile for " + user.getName());
        }
    }

    @Override
    public void help() {
        real.help();   // ingen rolle krævet — delegér direkte
    }
}
