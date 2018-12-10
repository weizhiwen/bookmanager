package cc.wenshixin.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AdRole {
    private Integer adRoleId;
    private String adRoleName;
    // 该角色的所有用户
    private Set<User> setUser = new HashSet<User>();

    public Set<User> getSetUser() {
        return setUser;
    }

    public void setSetUser(Set<User> setUser) {
        this.setUser = setUser;
    }

    public Integer getAdRoleId() {
        return adRoleId;
    }

    public void setAdRoleId(Integer adRoleId) {
        this.adRoleId = adRoleId;
    }

    public String getAdRoleName() {
        return adRoleName;
    }

    public void setAdRoleName(String adRoleName) {
        this.adRoleName = adRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdRole adRole = (AdRole) o;
        return Objects.equals(adRoleId, adRole.adRoleId) &&
                Objects.equals(adRoleName, adRole.adRoleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adRoleId, adRoleName);
    }
}
