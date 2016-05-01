'use strict'

exports.countZeros = function(text){
    var cont = 0;
    for(var j = 0; j < text.length; j++){
        if(text[j] == 0){
            cont++;
        }
    }
    return cont;
}
