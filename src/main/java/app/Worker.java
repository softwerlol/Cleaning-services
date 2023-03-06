package app;
import java.util.ArrayList;
import java.util.List;
public class Worker extends User{
    List<Worker> onlineWorker = new ArrayList<>();
    Application app = new Application();

    public Worker(String userName) {
        super(userName);
    }

    public Worker(String userName, String password) {
        super(userName, password);
    }

    public Worker() {
    }

    public Worker(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }

    public void workerSignUpValidation(Worker w) {
        w.validUsername(w.getUserName(), "w");
        w.validPassword(w.getPassword());
        if (w.getPointer()[0] && w.getPointer()[1]) {
            w.pointer[4] = true;
        } else {
            w.pointer[4] = false;
        }

    }

    public void addOnlineWorker(Worker w) {

        this.workerSignUpValidation(w);
        if (w.getPointer()[4]) {
            w.pointer[5] = true;
        }
    }

}
