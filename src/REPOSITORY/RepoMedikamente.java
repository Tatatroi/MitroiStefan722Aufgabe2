package REPOSITORY;

import Model.Medikamente;

import java.util.ArrayList;
import java.util.List;

public class RepoMedikamente implements IRepo<Medikamente>{
    List<Medikamente> medikamente = new ArrayList<>();

    @Override
    public void add(Medikamente obj) {
        medikamente.add(obj);
    }

    @Override
    public void update(Medikamente obj) {
        medikamente.set(medikamente.indexOf(obj), obj);
    }

    @Override
    public void delete(int id) {
        medikamente.remove(id);
    }

    @Override
    public Medikamente get(int id) {
        return medikamente.get(id);
    }

    @Override
    public List<Medikamente> getAll() {
        return medikamente;
    }

    public Medikamente takeByName(String name){
        for (int i = 0; i < medikamente.size(); i++) {
            if (medikamente.get(i).getName().equals(name)) {
                return medikamente.get(i);
            }
        }
        return null;
    }
}
