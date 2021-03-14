package com.ecbpm.controller;

import com.ecbpm.pojo.AdminInfo;
import com.ecbpm.pojo.Functions;
import com.ecbpm.pojo.TreeNode;
import com.ecbpm.service.AdminInfoService;
import com.ecbpm.util.JsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SessionAttributes(value = {"admin"})
@Controller
@RequestMapping("/admininfo")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(AdminInfo adminInfo, ModelMap modelMap) {
        AdminInfo ai = adminInfoService.login(adminInfo);
        if (ai != null && ai.getName() != null) {
            if (adminInfoService.getAdminInfoAndFunctions(ai.getId()).getFs().size() > 0) {
                modelMap.put("admin", ai);
                return "{\"success\":\"true\",\"message\":\"登录成功\"}";
            } else {
                return "{\"success\":\"false\",\"message\":\"您没有权限，请联系超级管理员设置权限\"}";
            }
        } else {
            return "{\"success\":\"false\",\"message\":\"登录失败\"}";
        }
    }

    @RequestMapping("getTree")
    @ResponseBody
    public List<TreeNode> getTree(@RequestParam(value = "adminid") String adminid) {
        AdminInfo adminInfo = adminInfoService.getAdminInfoAndFunctions(Integer.parseInt(adminid));
        List<TreeNode> nodes = new ArrayList<>();
        List<Functions> functionsList = adminInfo.getFs();
        Collections.sort(functionsList);
        for (Functions functions : functionsList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(functions.getId());
            treeNode.setFid(functions.getParentId());
            treeNode.setText(functions.getName());
            nodes.add(treeNode);
        }
        List<TreeNode> treeNodes = JsonFactory.buildTree(nodes, 0);
        return treeNodes;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String loginOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "{\"success\":\"true\",\"message\":\"注销成功\"}";
    }
}
