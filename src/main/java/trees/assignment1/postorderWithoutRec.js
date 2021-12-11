//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
    var firststack = [], secondstack = [];
    var it = root;
    firststack.push(it);
    var i = 0

    while(firststack.length){

        let tmp = firststack.pop();
        if(tmp){
            secondstack.push(tmp.val);

            if(tmp.left)
                firststack.push(tmp.left);

            if(tmp.right)
                firststack.push(tmp.right);
        }

    }

    return secondstack.reverse();

};