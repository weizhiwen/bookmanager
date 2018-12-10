package cc.wenshixin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RdType {
    private Integer rdTypeId;
    private String rdTypeName;
    private Integer canLendCount;
    private Integer canLendDay;
    private Integer canCountTime;
    private Float fineRate;
    private Integer dateValid;
    //读者类型下的读者
    private Set<User> setUser = new HashSet<User>();

    public Set<User> getSetUser() {
        return setUser;
    }

    public void setSetUser(Set<User> setUser) {
        this.setUser = setUser;
    }

    public Integer getRdTypeId() {
        return rdTypeId;
    }

    public void setRdTypeId(Integer rdTypeId) {
        this.rdTypeId = rdTypeId;
    }

    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }

    public Integer getCanLendCount() {
        return canLendCount;
    }

    public void setCanLendCount(Integer canLendCount) {
        this.canLendCount = canLendCount;
    }

    public Integer getCanLendDay() {
        return canLendDay;
    }

    public void setCanLendDay(Integer canLendDay) {
        this.canLendDay = canLendDay;
    }

    public Integer getCanCountTime() {
        return canCountTime;
    }

    public void setCanCountTime(Integer canCountTime) {
        this.canCountTime = canCountTime;
    }

    public Float getFineRate() {
        return fineRate;
    }

    public void setFineRate(Float fineRate) {
        this.fineRate = fineRate;
    }

    public Integer getDateValid() {
        return dateValid;
    }

    public void setDateValid(Integer dateValid) {
        this.dateValid = dateValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RdType rdType = (RdType) o;
        return Objects.equals(rdTypeId, rdType.rdTypeId) &&
                Objects.equals(rdTypeName, rdType.rdTypeName) &&
                Objects.equals(canLendCount, rdType.canLendCount) &&
                Objects.equals(canLendDay, rdType.canLendDay) &&
                Objects.equals(canCountTime, rdType.canCountTime) &&
                Objects.equals(fineRate, rdType.fineRate) &&
                Objects.equals(dateValid, rdType.dateValid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rdTypeId, rdTypeName, canLendCount, canLendDay, canCountTime, fineRate, dateValid);
    }
}
