/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if(head === null)
        return null;
   var firstPointer = head,secondPointer = head;
    while(n>0){
       secondPointer = secondPointer.next;
        n--;
   }
    if(secondPointer == null){
        head = head.next;
        return head;
    }


    while(secondPointer.next != null){
        secondPointer = secondPointer.next;
        firstPointer = firstPointer.next;
    }

    firstPointer.next = firstPointer.next.next;

    return head;

};