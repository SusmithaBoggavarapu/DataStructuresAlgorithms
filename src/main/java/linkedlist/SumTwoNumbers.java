package linkedlist;


public class SumTwoNumbers {

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        list1.printList();
        LinkedList list2 = new LinkedList();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        list2.printList();

        LinkedList res = addTwoList(list1.getHead(),list2.getHead());
        res.printList();
    }

    public static LinkedList addTwoList(Node list1 , Node list2){
        LinkedList res = new LinkedList();
        int carry = 0;
        while (list1 != null || list2 != null){

            int val;
            if(list1 == null){
                val = carry + list2.getVal();
            } else if( list2 ==  null){
                val = carry + list1.getVal();
            }else{
                val = carry + list1.getVal() + list2.getVal();
            }

            carry = val / 10;
            val = val % 10;
            res.add(val);
            list1 = list1!= null ? list1.getNext() :null;
            list2 = list2 != null ? list2.getNext() : null;
        }



        if(carry != 0){
            res.add(carry);
        }
        return res;
    }
}
