package cc.wenshixin.action;

import cc.wenshixin.entity.RdType;
import cc.wenshixin.service.RdTypeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RdTypeAction extends ActionSupport implements ModelDriven<RdType>{
    // 模型驱动封装
    private RdType rdType = new RdType();
    @Override
    public RdType getModel() {
        return rdType;
    }

    // 属性注入
    private RdTypeService rdTypeService;
    public void setRdTypeService(RdTypeService rdTypeService) {
        this.rdTypeService = rdTypeService;
    }


    // 转到添加读者类型页面
    public String toAddPage() {
        return "toAddPage";
    }

    // 添加读者类型的方法
    public String add() {
        rdTypeService.add(rdType);
        return "add";
    }

    // 转到修改界面
    public String toEditPage() {
        int id = rdType.getRdTypeId();
        System.out.println(id);
        RdType type = rdTypeService.findOne(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdType", type);
        return "toEditPage";
    }

    // 修改读者类型方法
    public String edit() {
        rdTypeService.update(rdType);
        return "edit";
    }

    // 删除读者类型的方法
    public String delete() {
        int id = rdType.getRdTypeId();
        RdType type = rdTypeService.findOne(id);
        if (type != null) {
            rdTypeService.delete(type);
        }
        return "delete";
    }

    // 查询所有读者类型
    public String list() {
        List<RdType> rdTypeList = rdTypeService.findAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("rdTypeList", rdTypeList);
        return "list";
    }
}
