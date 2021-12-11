//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number}
 */
var getDecimalValue = function(head) {
    var it = head;
    var decVal = 0;
    while(it){
        decVal = 2*decVal + it.val;
        it = it.next;
    }
    console.log(decVal);
    return decVal;
};