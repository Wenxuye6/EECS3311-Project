package dao.impl;

import bean.Equipment;
import dao.BaseDAO;
import dao.EquipmentDAO;

import java.util.List;

public class EquipmentDAOImpl extends BaseDAO<Equipment> implements EquipmentDAO {
    @Override
    public Object[][] getEquipmentArrayList() {
        String sql = "select * from t_equipment";
        List<Object[]> l = getArrayList(sql);
        Object[][] list = new Object[l.size()][4];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public void changeEquipment(Equipment newEquipment) {
        String sql = "update `t_equipment` set `equipmentName`=?,`currentNum`=?,`damagedNum`=?,`marketPrice`=?,`value`=? where `equipmentId`=?";
        update(sql, newEquipment.getEquipmentName(), newEquipment.getCurrentNum(), newEquipment.getDamagedNum(),
                newEquipment.getMarketPrice(), newEquipment.getValue(), newEquipment.getEquipmentId());
    }

    @Override
    public void deleteEquipmentById(int id) {
        String sql = "delete from `t_equipment` where `equipmentId`=?";
        update(sql, id);
    }

    @Override
    public boolean addEquipment(Equipment equipment) {
        if (isExists(equipment.getEquipmentName())) {
            return false;
        }
        String sql = "insert into `t_equipment`(`equipmentName`,`currentNum`,`damagedNum`,`marketPrice`,`value`)values(?,?,?,?,?)";
        return update(sql, equipment.getEquipmentName(), equipment.getCurrentNum(), equipment.getDamagedNum(), equipment.getMarketPrice(), equipment.getValue()) > 0;
    }

    @Override
    public boolean isExists(String name) {
        String sql = "select * from `t_equipment` where `equipmentName`=?";
        return getBean(sql, name) != null;
    }
}
