exports.newMovement = function(gameArray){
    var columZeros = [];
    for(i = 0; i < gameArray.length; i++){
        if(countZeros(gameArray[i]) > 0){
            columZeros.push(i);
        }
    }
    var randomNumber = Math.floor(Math.random()*columZeros.length+0);
    return (columZeros[randomNumber]);
}


var countZeros = function(text){
    cont = 0;
    for(j = 0; j < text.length; j++){
        if(text[j] == 0){
            cont++;
        }
    }
    return cont;
}
