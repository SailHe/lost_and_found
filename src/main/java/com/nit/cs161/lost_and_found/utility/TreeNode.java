package com.nit.cs161.lost_and_found.utility;

import java.util.*;

/**
 * Description: n叉树结点<p>
 *
 * @Package: com.nit.cs161.lost_and_found.utility
 * @author: SailHe
 * @date: 2018/4/17 13:59
 */
public class TreeNode<DataType> {
    private DataType data;
    private List<TreeNode<DataType>> subs = new LinkedList<>();

    public TreeNode(DataType data) {
        this.data = data;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }

    public boolean branchesASubNode(DataType data) {
        return subs.add(new TreeNode<>(data));
    }

    /**
     * Descriptions: 分支出n个结点 子结点的数据依次为 dataCollection 中的数据<p>
     *
     * @author SailHe
     * @date 2018/4/17 14:16
     */
    public boolean branchesAllSubNode(Collection<DataType> dataCollection) {
        boolean success = true;
        if(dataCollection == null){
            return true;
        }
        for (DataType data : dataCollection) {
            if (success) {
                success = success && subs.add(new TreeNode<>(data));
            } else {
                break;
            }
        }
        return success;
    }

    /**
     * Descriptions: 为每个子结点都建一个分支 数据为传入的List(以少的为准)<p>
     *
     * @author SailHe
     * @date 2018/4/17 14:45
     */
    public void branchesGrandsonNode(Iterator<DataType> dater) {
        for (Iterator<TreeNode<DataType>> i = iteratorSub(); i.hasNext() && dater.hasNext(); ) {
            i.next().branchesASubNode(dater.next());
        }
    }

    public Iterator<TreeNode<DataType>> iteratorSub() {
        return subs.iterator();
    }

    @Override
    public String toString() {
        String str = "";
        for (TreeNode s : subs) {
            str += s.toString();
        }
        if (str != "") {
            str = " [" + str + "] ";
        }
        return data.toString() + str;
    }

    public static void main(String[] args) {
        TreeNode<Integer> temp = new TreeNode<>(-1);
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        temp.branchesAllSubNode(array);
        temp.branchesGrandsonNode(array.iterator());
        System.out.println(temp);
    }
}
