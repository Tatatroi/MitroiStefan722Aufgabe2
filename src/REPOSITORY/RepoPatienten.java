package REPOSITORY;

import Model.Patienten;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepoPatienten implements IRepo<Patienten> {
    Map<Integer, Patienten> dataPatienten = new HashMap<>();
    @Override
    public void add(Patienten obj) {
        dataPatienten.put(obj.getId(), obj);
    }

    @Override
    public void update(Patienten obj) {
        dataPatienten.replace(obj.getId(), obj);
    }

    @Override
    public void delete(int id) {
        dataPatienten.remove(id);
    }

    @Override
    public Patienten get(int id) {
        return dataPatienten.get(id);
    }

    @Override
    public List<Patienten> getAll() {
        return dataPatienten.values().stream().toList();
    }

}
