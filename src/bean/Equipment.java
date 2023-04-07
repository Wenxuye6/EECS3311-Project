package bean;

public class Equipment {
    private Integer equipmentId;
    private String equipmentName;
    private Integer currentNum;
    private Integer damagedNum;
    private Double marketPrice;
    private String value;

    public Equipment() {
    }

    public Equipment(Integer equipmentId, String equipmentName, Integer currentNum, Integer damagedNum, Double marketPrice, String value) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.currentNum = currentNum;
        this.damagedNum = damagedNum;
        this.marketPrice = marketPrice;
        this.value = value;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getDamagedNum() {
        return damagedNum;
    }

    public void setDamagedNum(Integer damagedNum) {
        this.damagedNum = damagedNum;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", currentNum=" + currentNum +
                ", damagedNum=" + damagedNum +
                ", marketPrice=" + marketPrice +
                ", value='" + value + '\'' +
                '}';
    }
}
