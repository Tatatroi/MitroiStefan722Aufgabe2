import CONTROLLER.Controller;
import Model.Medikamente;
import Model.Patienten;
import REPOSITORY.RepoMedikamente;
import REPOSITORY.RepoPatienten;
import UI.Ui;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RepoMedikamente repoMed = new RepoMedikamente();
        RepoPatienten repoCli = new RepoPatienten();

        Medikamente med1 = new Medikamente("Nurofen", 100,"UPU");
        Medikamente med2 = new Medikamente("Paracetamol", 110,"OPO");
        Medikamente med3 = new Medikamente("A", 90,"UPU");
        Medikamente med4 = new Medikamente("Strepsils", 10,"UPU");

        repoMed.add(med1);
        repoMed.add(med2);
        repoMed.add(med3);
        repoMed.add(med4);

        List<Medikamente> lista1 = Arrays.asList(med1,med2);
        List<Medikamente> lista2 = Arrays.asList(med1,med2);
        List<Medikamente> lista3 = Arrays.asList(med3,med4);

        repoCli.add(new Patienten(1,"Mitroi", 10,"Prost",lista1));
        repoCli.add(new Patienten(2,"Miki", 11,"Tampit",lista2));
        repoCli.add(new Patienten(3,"Magu", 12,"Lenes",lista3));

        Controller controller = new Controller(repoMed, repoCli);
        Ui ui = new Ui(controller);

        ui.start();
    }
}