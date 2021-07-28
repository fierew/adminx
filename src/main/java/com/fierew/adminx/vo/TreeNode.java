package com.fierew.adminx.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {
    protected int id;
    protected int parentId;
    protected String name;
    protected List<TreeNode> children = new ArrayList<>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
