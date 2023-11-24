# bot-pathing
Bot that follows input commands for movement on an XY  axis plane  
# Explaination 
Initially `Bot` have (0,0) axis and facing the `NORTH` direction. From the problem ,we can get , If Bot will move Left , it rotates its direction 90 clockwise, It means If previous direction is north and bot moving to left direction will change to EAST , similarly if direction is EAST and bot moves left , direction will change to SOUTH clock wise..similarly for other direction....
For right it moves anticlockwise, if direction is EAST and right moves ... direction will change into North, if direction is North and left moves then as anticlockwise it changes direction to West.
For axis if right moves it will add from previous axis and for left move it will subtract.  

# Pseudo code 
1. Set initial direction of bot to `NORTH` with axis `(0,0)`
2. Loop on given direction&movment
   1. If `R` (right) input  is given with `n` movement:
      1. Update `x` Axis as (x+n, y) , (where x, y are previous axis)
	  2. check direction of bot , If: 
		  1. direction is `NORTH` ... rotate bot into `EAST direction`
		  2. direction is `EAST` ... rotate bot into `SOUTH direction`
		  3. direction is `SOUTH` ... rotate bot into `WEST direction`
		  4. direction is `WEST` ... rotate bot into `NORTH direction`

   2. If `L` (left) input  is given with `n` movement:
      1. Update `x` Axis as (x-n, y) , (where x, y are previous axis)
	  2. check direction of bot , If: 
		  1. direction is `NORTH` ... rotate bot into `WEST direction`
		  2. direction is `WEST` ... rotate bot into `SOUTH direction`
		  3. direction is `SOUTH` ... rotate bot into `EAST direction`
		  4. direction is `EAST` ... rotate bot into `NORTH direction`
3. Print rotated direction + current axis
# How to run?

For java, There is `PathBot.jar` , which can be run using `java -jar PathBot.jar RM15 LM10`. <br>
For Python, `path-bot.py  RM15 LM10`

For running from source , `javac PathBot.java && java PathBot RM15`

Tested in : `Java17 (for java)`, `python 3.11 ( for python)`
