package util;

import java.math.BigDecimal;

public class Member_TypeTM {
    private String typeID;
    private String TypeDesc;
    private BigDecimal charges;

    public Member_TypeTM() {
    }

    public Member_TypeTM(String typeID, String typeDesc, BigDecimal charges) {
        this.typeID = typeID;
        TypeDesc = typeDesc;
        this.charges = charges;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeDesc() {
        return TypeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        TypeDesc = typeDesc;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "Member_TypeTM{" +
                "typeID='" + typeID + '\'' +
                ", TypeDesc='" + TypeDesc + '\'' +
                ", charges=" + charges +
                '}';
    }
}
