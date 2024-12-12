import repository.PatientRepositoryImpl;
import entities.Patient;
import service.PatientService;
import view.ConsoleView;

public class main {
    public static void main(String[] args) {

        PatientRepositoryImpl repository = new PatientRepositoryImpl();
        PatientService service = new PatientService(repository);
        ConsoleView view = new ConsoleView(service);

        view.showMainMenu();
    }

}