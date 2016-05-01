'use strict'

var gameLogic = require('./js/winner.js');
var level1 = require('./js/level1.js');
var level2 = require('./js/level2.js');
var level3 = require('./js/level3.js');

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

app.get('/sendGameMatriz/:matriz/:level/:player', function(req,res){
    var matriz = req.params.matriz;
    var level = req.params.level;
    var player = req.params.player;

    //console.log(player);

    var jsonMatriz = JSON.parse(matriz);
    if(gameLogic.checkWinner(jsonMatriz, 1)){
        res.json({"data":"OK","winner":"1", "moveColum":-1});

    }else if(gameLogic.checkWinner(jsonMatriz, 2)){
        res.json({"data":"OK","winner":"2", "moveColum":-1});

    }else{
      if (level == 1) {
          res.json({"data":"OK","winner":"0","moveColum":level1.newMovement(jsonMatriz)});
      }else if (level == 2) {
          res.json({"data":"OK","winner":"0","moveColum":level2.newMovement(jsonMatriz,player)});
          //level2.newMovement(jsonMatriz,player);

      }
    }


});


app.get('/getGameData/:email',function(req,res){
    var user = req.params.email;
	db.gamesData.findOne({user1:user},function(err,docs){
		res.json(docs);
        console.log(docs.data);
	});
});



app.listen(port);
console.log("Server ok in port: "+port);
