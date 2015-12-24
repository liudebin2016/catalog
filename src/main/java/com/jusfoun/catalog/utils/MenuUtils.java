package com.jusfoun.catalog.utils;

import com.jusfoun.catalog.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elvis on 15/12/23.
 */
public class MenuUtils {


    /**
     * @Title: getRoot
     * @Description 方法描述: 子节点
     * @param: pid
     * @param: menuList
     * @return:
     * @return: 返回类型: Menu
     * @throws:
     * @date 最后修改时间: 2015-12-24 09:52:00
     */
    public final static Menu getRoot(List<Menu> menuList){

        for(Menu menu : menuList){
            if(menu.getParentId() == 0){
                return menu;
            }
        }
        return null;
    }

    /**
     * @Title: getTreeList
     * @Description 方法描述: 子节点
     * @param: pid
     * @param: treeDataList
     * @return:
     * @return: 返回类型: List<Menu>
     * @throws:
     * @date 最后修改时间: 2015-12-24 09:52:00
     */
    public final static List<Menu> getTreeList(Integer pid, List<Menu> menuList){
        List<Menu> newTreeDataList = new ArrayList<Menu>();
        for(Menu menu : menuList){
            if(menu.getParentId() == pid){
                newTreeDataList.add(menu);
            }
        }
        return newTreeDataList;
    }
    //TODO...递归无限级菜单...
    public final static Menu buildTree(List<Menu> menuList){

        Menu root = getRoot(menuList);
        List<Menu> menus = getTreeList(root.getId(),menuList);
        for(Menu menu :menus){
            List<Menu> secMenus = getTreeList(menu.getId(),menuList);
            menu.setChildren(secMenus);
        }
        root.setChildren(menus);
        return root;
    }



}
