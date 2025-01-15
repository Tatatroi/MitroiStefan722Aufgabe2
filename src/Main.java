import CONTROLLER.Controller;
import REPOSITORY.RepoMedikamente;
import REPOSITORY.RepoPatienten;
import UI.Ui;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RepoMedikamente repoMed = new RepoMedikamente();
        RepoPatienten repoCli = new RepoPatienten();

        Controller controller = new Controller(repoMed, repoCli);
        Ui ui = new Ui(controller);

        ui.start();
    }
}