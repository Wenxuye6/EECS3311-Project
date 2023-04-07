package dao;

import bean.Equipment;

public interface EquipmentDAO {

    Object[][] getEquipmentArrayList();

    void changeEquipment(Equipment newEquipment);

    void deleteEquipmentById(int id);

    boolean addEquipment(Equipment equipment);

    boolean isExists(String name);
}
