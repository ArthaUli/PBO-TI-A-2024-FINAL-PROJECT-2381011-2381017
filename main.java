import repository.PatientRepositoryImpl;
import service.PatientService;
import view.ConsoleView;

public class main {
    public static void main(String[] args) {

        var patientRepository = new PatientRepositoryImpl();
        var patientService = new PatientService(patientRepository);
        var consoleView = new ConsoleView(patientService);

        consoleView.showMainMenu();
    }
}
