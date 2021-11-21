//https://leetcode.com/problems/remove-linked-list-elements/
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    if(!head)
        return null;
    var it = head;
    while(it && it.val === val){
      it = it.next;
    }
    head = it;
    if(!it)
        return null;

    var prev = it;
    while(it){

        if(it.val === val){
            prev.next = it.next;
        }else{
            prev = it;
        }
        it = it.next;
    }

    return head;
};