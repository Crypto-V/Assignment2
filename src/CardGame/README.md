# Assignment2
WalkThrough Assignment2

Introduction
Elevens is a single-player card game that uses a standard deck of playing cards. The object of the
game is to remove all 52 cards from the playing area by matching them in one of 2 ways as
follows:
i) by removing a pair of (non-picture) cards for which the combined rank value is 11 (i.e. a
pair of cards where neither is a Jack, Queen or King). The rank value of an Ace is 1 and
cards from 2-10 take the rank value of their number. Pairs that can be removed are
therefore Ace and Ten, Two and Nine, Three and Eight, Four and Seven, Five and Six.
ii) by removing a King, Queen and Jack (of any suit or mixed suits) at the same time.

The game begins by dealing 9 cards from a shuffled deck, so that the cards are face-up (i.e. the
values of the cards are visible). The player examines the 9 cards and, if two or three cards can be
seen that satisfy either of the removal conditions above, those cards can be removed. As cards
are removed, they are replaced by cards from the remainder of the deck, for as long as the deck
has cards remaining.

The game is won when all 52 cards are removed from the game. If a stalemate is reached where
neither of the conditions for removal can be satisfied, then the game is lost.
The rules of Elevens can be seen online at https://gamerules.com/rules/elevens/ and a
demonstration video can be seen at https://www.youtube.com/watch?v=c-Yi1WlwQAk
Note that your application will be a pure text version – with keyboard input. There is no
requirement for a graphical or mouse-based solution.

Required Functionality
There are 6 levels to which the submission can be completed – attracting increasing rewards.
Level 1: The facilities to create a new game are present and the game can be set up in its
initial state, with 9 cards dealt face-up from a shuffled deck.
Level 2: The basic game mechanism is in place. Users can select legal combinations of
cards to be removed and they are replaced by new cards dealt from the deck (for
as long as the deck has cards available). 
Level 3: A full playable game is available. The application is able to prompt the player
when the game is won (all cards removed) or lost (stalemate is reached as no
cards can be removed).
Level 4: The game is able to provide a hint to the player (on request) suggesting a valid
move or confirming that no move is possible.
Level 5: On completion of a game (whether the player has won or lost) the application is
able to replay the game move by move, with the user prompting each replayed
move by a keypress.
Level 6: The application is able to play a complete game in “demonstration mode”, where
the only input from the player is to prompt the application to play its next move.
The computer should provide a commentary on each move made such as “3 of
Spades and 8 of Diamonds removed”, “King of Clubs, Queen of Diamonds and Jack
of Hearts removed” and so on. 
