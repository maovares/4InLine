'use strict'

var gameLogic = require('./js/winner.js');
var level1 = require('./js/level1.js');

var express = require('express');
var app = express();
var mongojs= require('mongojs');
var db = mongojs('localhost:27017/db4',['gamesData','gamesCounter']);
var bodyParser = require('body-parser');
var port = 3000;

app.use(express.static(__dirname+'/public'));
app.use(bodyParser.json());

/*
app.get('/getGameData',function(req, res){
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(matrix));
  console.log(matrix);
});

app.get('/sendGameData',function(req, res) {

});*/

app.get('/sendGameMatriz/:matriz/:level', function(req,res){
    var matriz = req.params.matriz;
    var level = req.params.level;
    
    //var user = req.params.email;
    //console.log(level);  
    //var winner = "0";
    
    var jsonMatriz = JSON.parse(matriz);
    if(gameLogic.checkWinner(jsonMatriz, 1)){
        res.json({"data":"OK","winner":"1", "moveColum":-1});
        
    }else if(gameLogic.checkWinner(jsonMatriz, 2)){
        res.json({"data":"OK","winner":"2", "moveColum":-1});
        
    }else{
        res.json({"data":"OK","winner":"0","moveColum":level1.newMovement(jsonMatriz)});
    }
    
    
});


app.get('/getGameData/:email',function(req,res){
    var user = req.params.email;
	db.gamesData.findOne({user1:user},function(err,docs){
		res.json(docs);
        console.log(docs.data);
	});
});



//gameLogic.checkWinner(matrix.data, 2);


app.listen(port);
console.log("Server ok in port: "+port);
