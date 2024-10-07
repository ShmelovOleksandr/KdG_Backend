package be.kdg.prog6.boundedcontextLandside.domain;

import java.math.BigDecimal;

public class Material {
    private MaterialType materialType;
    private BigDecimal tons;

    public Material() {
    }

    public Material(MaterialType materialType, BigDecimal tons) {
        this.materialType = materialType;
        this.tons = tons;
    }

    public void increaseTons(BigDecimal extraTons) {
        this.tons = this.tons.add(extraTons);
    }

    public void decreaseTons(BigDecimal removedTons) {
        this.tons = this.tons.subtract(removedTons);
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public BigDecimal getTons() {
        return tons;
    }

    public void setTons(BigDecimal tons) {
        this.tons = tons;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialType=" + materialType +
                ", tons=" + tons +
                '}';
    }
}
