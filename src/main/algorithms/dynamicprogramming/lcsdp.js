/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    var memres = Array(text1.length+1).fill().map(() => Array(text2.length+1).fill(0));
    //console.log(memres);
    longestCommonSubsequenceMemorized(text1,text2,memres,0,0);
   // console.log(memres);
    return memres[0][0];

};

var longestCommonSubsequenceMemorized = function(text1, text2,memres,i,j) {
    //console.log("text1: "+ text1 +" text2"+ text2 + " i: "+i+ "j: "+ j )
    if(!text1 || !text2){
        return 0;
    }

     //console.log(" i: "+i+ "j: "+ j )
       //  console.log("memres[i][j]"+ memres[i][j]);
    if(text1.charAt(0) == text2.charAt(0)){

        if(!memres[i][j]){

            memres[i][j] = 1+ longestCommonSubsequenceMemorized(text1.substring(1),text2.substring(1),memres,i+1,j+1);
        }

    }else{
        if(!memres[i+1][j] ){
         memres[i+1][j] = longestCommonSubsequenceMemorized(text1.substring(1),text2,memres,i+1,j);
        }

        if(!memres[i][j+1]){
            memres[i][j+1] = longestCommonSubsequenceMemorized(text1,text2.substring(1),memres,i,j+1);
        }

        memres[i][j] = Math.max( memres[i+1][j],memres[i][j+1] );
    }
    return memres[i][j];

};

