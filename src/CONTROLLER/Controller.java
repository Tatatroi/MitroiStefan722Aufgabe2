package CONTROLLER;

import Model.Medikamente;
import Model.Patienten;
import REPOSITORY.RepoMedikamente;
import REPOSITORY.RepoPatienten;

import java.util.List;

public class Controller {
    private RepoMedikamente repoMedikamente;
    private RepoPatienten repoPatienten;
    private int newPatientenId = 0;

    public Controller(RepoMedikamente repoMedikamente, RepoPatienten repoPatienten) {
        this.repoMedikamente = repoMedikamente;
        this.repoPatienten = repoPatienten;
    }

    // CREATE

    public void createMedicament(String name, int price, String krankenheit) {
        repoMedikamente.add(new Medikamente(name,price,krankenheit));
    }

    public void createPatient(String name, int age, String diagnose, List<Medikamente> meds) {
        repoPatienten.add(new Patienten(++newPatientenId, name, age,diagnose, meds));
    }

    // UPDATE

    public void updateMedikament(String nameMed, int price, String krankenheit) {
        Medikamente med = repoMedikamente.takeByName(nameMed);
        med.setPreis(price);
        med.setKrankenheit(krankenheit);
        repoMedikamente.update(med);
    }

    public void updateKunde(int id, String name, int age, String diagnose, List<Medikamente> meds) {
        repoPatienten.update(new Patienten(id,name,age,diagnose,repoPatienten.get(id).getMedikamenteList()));
    }

    // DELETE

    public void deletePatient(Integer id) {
        repoPatienten.delete(id);
    }

    public void deleteMedicament(String nameProdukt) {
        for(int i = 0; i<repoMedikamente.getAll().size(); i++){
            if(repoMedikamente.getAll().get(i).getName().equals(nameProdukt)){
                repoMedikamente.delete(i);
                break;
            }
        }
    }

    //GET

    public List<Medikamente> getAllMedikamente() {
        return repoMedikamente.getAll();
    }

    public List<Patienten> getAllPatienten() {
        return repoPatienten.getAll();
    }

    public Medikamente getMedikamenteByName(String name) {
        return repoMedikamente.takeByName(name);
    }

    public Patienten getPatient(int id){
        return repoPatienten.get(id);
    }

}
