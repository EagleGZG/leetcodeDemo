package com.wuj.leetcode;

import java.awt.*;

/**
 * @author xiaoyi
 */
public class TwoNumsAdd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode  result = null;
        ListNode  end = null;
        ListNode  current = null;

        boolean isAdd = false;
        while(l1 != null || l2 != null){

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int count = x + y;
            if(isAdd){
                count = count + 1;
            }
            if(count >= 10 ){
                isAdd = true;
            }else{
                isAdd = false;
            }

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

            current = new ListNode(count % 10);
            if(result == null){
                result = current;
                end = result;
            }else{
                end.next = current;
                end = end.next;
            }
        }
        if(isAdd){
            end.next = new ListNode(1);
            end = end.next;
        }
        return result;
    }

    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode next = new ListNode(8);
        l1.next = next;

        ListNode l2 = new ListNode(0);

        ListNode result = addTwoNumbers(l1,l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }


    }

}
