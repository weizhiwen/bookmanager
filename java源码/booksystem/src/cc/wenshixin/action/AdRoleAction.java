package cc.wenshixin.action;

import cc.wenshixin.service.AdRoleService;
import com.opensymphony.xwork2.ActionSupport;

public class AdRoleAction extends ActionSupport {
    // 属性注入
    private AdRoleService adRoleService;
    public void setAdRoleService(AdRoleService adRoleService) {
        this.adRoleService = adRoleService;
    }
}
