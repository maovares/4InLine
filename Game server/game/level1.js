'use strict'

var utilities = require('./utilities.js');

exports.newMovement = function(gameArray){
    var columZeros = [];
    for(i = 0; i < gameArray.length; i++){
        if(utilities.countZeros(gameArray[i]) > 0){
            columZeros.push(i);
        }
    }
    var randomNumber = Math.floor(Math.random()*columZeros.length+0);
    return (columZeros[randomNumber]);
}
