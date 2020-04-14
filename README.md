# T06Group4
Tutorial 06 Group 4 Repository
Repository Name: T06Group4
Repository address: https://github.com/alejandroescobar1/T06Group4

This repository contains the code needed to play the Treasure Hunt game.

The final demo version can be found under the "Interactive-Demo" Branch of the repository.

To run this code, download all ten class flies and one .css file: AlertBox.java, Character.java,Coordinate.java,Items.java, Maze.java, MazeGUI.java, Mummies,MummiesTimer.java, Player.java,and Score.java and application.css. Import all theseclasses into the "application" package of src. 

Also download all the .png and .gif files and put into "images" package of src. The default layout on this branch also shows how these package structure should be like under src.

Run the game by running the MazeGUI.java class. Then select a character by clicking on any of the five character options on screen. And then input the dimension of length and width, note that they have to be the same integers.Then press the "play button".

This final version of the code allows the player to use the "W"-"A"-"S"-"D" keys on their keyboard to navigate the maze that also has a mummy that obeys the layout of the maze walls and chase player obeying a shortest path. 

In addition, the code also keeps track of the user's score. The score is based on a combination of time it takes to finish, the lives remaining, the mummy it has killed, and the items it have collected.

The player can collect any of the four types of items on screen: Gem-add score(100), Jewel - add 1 extra life and add score(300), Staff - add score(300) and let user kills the mummy(send it back to top right corner and for user to collect extra score), and Ring - lose 1 life and lose score(300).

When the player reaches the bottom right corner, a win screen pop up, to show the score, and details on time took, items collected, mummy killed, etc. And in the contrary, when player hits mummmy without first collecting a Staff item, it loses 1 life and both player and mummy are being sent back to the starting point 0,0 and top right corner, respectively. And after player loses all his life, a loss screen pops up.
