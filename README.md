# ProjectMinesweeper

# Project Name: Minesweeper

# Description:
What?

We are making our own version of the game Minesweeper with the main goal of making it a
2-player game. We are going to have 2 players compete on 2 different boards, and the winner of 
the two will be determined by who finishes their board first or whoever loses first doesn't win.

Why?

This specific version of Minesweeper is one that we have never seen be implemented before, 
so our goal is to hopefully create what could be a great addition to the existing game.

How?

The way we are thinking of accomplishing this is using Peer-to-Peer connection to connect 
both players to the game. Once connected, each player will have their own board and the program
will constantly check whether one player has either won or lost, and if one player achieves
either state, then the other player also receives the end code.

# Deliverables: 
1. What we plan to deliver at the end of the semester is a 2-player
version of Minesweeper built using Peer-To-Peer connection and establishing constant 
communication between the 2 players throughout the game. 
2. Both players will see 2 different boards on the screen, one representing their board, 
the other the opponent's board. Each player will only be able to interact with their own 
board, and each board is randomly genereated. 
3. The game will have end screens for each possible scenario for when the game ends. When 
one player wins, the other player automatically loses. If one player loses due to detonating 
a bomb, then the other player automatically wins. 
4. We will also allow each player to flag the bombs if they find their locations, and choose 
the size of the board at the start of the game.

# Plan:

* Week 1
- Research how our goal can be achieved, and what needs to be done.
* Week 2
- Agree on a design to implement the code. We will be doing a peer-to-peer architecture for
our code to implement 2-player functionality.
* Week 3
- Start implementing the code. Write client and server classes. Hopefully be at least close or
finished with adding 2-player functionality to the game. Add end screens for each scenario where
each player either wins or loses.
* Week 4
- Finish implementing 2-player functionality if necessary. Implement GUI elements for both
players, so the players can easily keep track of what they're doing.
* Week 5
- Mostly testing, checking for errors. Hopefully by this point we will have addressed most of any
blocking issues or challenges that we may face.
* Week 6
- Debugging, polishing if possible. Continue to address blocking issues if any, and possibly
expand beyond this project. For example, thinking about implementing a client-server architecture
should this game involve more than 2 players in the future.

# Getting Started
Install

Run

# Features
1. 2-player version of Minesweeper using peer-to-peer connection.
2. The players can choose the size of the boards before the start of the game.
3. The players can see both boards, but can only interact with their own board.
4. The game is divided into rounds (for example, a best of 7), where the first to 4 wins in this case wins the game.

# Demo Video

# Team members: 
* Camden Parsons, Programmer
* Giga Apkhaidze, Programmer
* Devin Denham, Programmer

# Comments
1. Have a better formatting of the whole document. You can download the README.md template from Blackboard and follow the formatting
2. Write more details about the deliverables. Think about what you are going to demo in the final presentation and compile the list of features to be delivered accordingly
3. Be more specific on the plan for each week. For example, implementing the code is too vague. What features in particular you implement this week, etc.
