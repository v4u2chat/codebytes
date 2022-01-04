package com.test.example;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + (next != null ? " , " + next : "");
    }

}

public class AddTwoLinkedLists {

    private int extractNumberFromList(ListNode node) {
        StringBuilder returnNumber = new StringBuilder();

        while (node != null) {
            returnNumber.append(node.val);
            node = node.next;
        }
        return Integer.parseInt(returnNumber.reverse().toString());
    }

    private ListNode buildListNodeFromInteger(int sum, ListNode nextNode) {
        nextNode.val = (sum % 10);
        int newSum = sum / 10;

        if (newSum > 0) {
            nextNode.next = buildListNodeFromInteger(newSum, new ListNode());
        }
        return nextNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = extractNumberFromList(l1);
        int n2 = extractNumberFromList(l2);
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
        return buildListNodeFromInteger(n1 + n2, new ListNode());

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode l1Node = l1;
        ListNode l2Node = l2;

        ListNode sumList = new ListNode();
        ListNode sumListPointer = sumList;

        int sum = 0;
        int carry = 0;

        while (l1Node != null || l2Node != null || carry!= 0) {

            sumListPointer.next = new ListNode();
            sumListPointer = sumListPointer.next;

            sum = carry + (l1Node != null ? l1Node.val : 0) + (l2Node != null ? l2Node.val : 0);
            carry = sum / 10;
            
            if(l1Node == null && l2Node == null){
                sumListPointer.val = sum;
                carry = 0;
            } else {
                sumListPointer.val = sum % 10;
            }
            

            l1Node = l1Node != null ? l1Node.next : null;
            l2Node = l2Node != null ? l2Node.next : null;

        }

        return sumList.next;

    }

    

    public static void main(String[] args) {
        AddTwoLinkedLists solution = new AddTwoLinkedLists();

        ListNode l1 = solution.buildListNodeFromInteger(99999999, new ListNode());
        // System.out.println(l1);

        ListNode l2 = solution.buildListNodeFromInteger(1, new ListNode());
        // System.out.println(l2);

        System.out.println("Sum : " + solution.addTwoNumbers2(l1, l2));

        System.out.println(10 % 10);
        System.out.println(10 / 10);

    }
}
