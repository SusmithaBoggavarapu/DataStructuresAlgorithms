/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {
    let i = 0;

    while(i<s.length && s.charAt(i) == ' '){
        i++;
    }
    console.log(i);

    if(i == s.length)
        return 0;
     console.log(isCharNumber(s.charAt(i)));

     if(! (isCharNumber(s.charAt(i)) || s.charAt(i)=="-" || s.charAt(i)=="+")){
              return 0;
        }
     var multiplier = 1;
    if(s.charAt(i) == "-"){
       multiplier = -1 ;
        i++;
    } else if(s.charAt(i) == "+"){
        i++;
              }
     console.log(i + "multiplier "+ multiplier);
    var res = 0;
    while( i < s.length && isCharNumber(s.charAt(i))){
        var digit = s.charAt(i) - '0';
        res = 10*res + digit ;
        i++;
    }
    res = res* multiplier;

    if(-2147483648 <= res && 2147483647 > res){
        return res;
    }else{
        if(multiplier == '-1'){
            return -2147483648;
        }else{
            return 2147483647;
        }
    }


};
var isCharNumber = function(c) {
  return c >= '0' && c <= '9';
}