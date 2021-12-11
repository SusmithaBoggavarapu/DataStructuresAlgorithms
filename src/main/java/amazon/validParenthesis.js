/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    var stack = [];
   for(var i=0;i<s.length;i++){
     var c  = s.charAt(i);
        if(c=='(' || c=='{' || c == '['){
            stack.push(c);

        }else{

            if(c==')'){
                if(!stack || stack.pop() != '(' ){
                    return 0;
                }


            }else if(c=='}'){
                 if(!stack || stack.pop() != '{' ){
                    return 0;
                }

            }else if(c==']'){
                  if(!stack || stack.pop() != '[' ){
                    return 0;
                }
            }

        }

    }

        return !stack.length;

};