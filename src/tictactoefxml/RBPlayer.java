package tictactoefxml;

import gr.teiemt.lmous.pega.Board;
import gr.teiemt.lmous.pega.Movement;
import gr.teiemt.lmous.pega.Player;

/**
 *
 * @author Lefteris
 */
public class RBPlayer extends Player {

  
    public RBPlayer(char s) {
        super(s);
    }
    

    @Override
    public Movement move(Board board) throws Exception {
        int i = 0,j = 0;
                Board cpyBrd = new Board(board);
                Movement move =new Movement(0,0);
                move=cpyBrd.possibleMoves();
                

               
        return  new Movement(i,j);
        
    }
}

























//              Movement move= new Movement(1,1);
//             
//               if(board.empty(move))return move;
//               move =new Movement(0,0);
//               if(board.empty(move)) return move;
//               move =new Movement(2,2);
//               if(board.empty(move)) return move;
//               move =new Movement(0,2);
//               if(board.empty(move)) return move;
//                move =new Movement(2,0);
//               if(board.empty(move)) return move;
//                move =new Movement(1,2);
//               if(board.empty(move)) return move;
//                move =new Movement(1,0);
//               if(board.empty(move)) return move;
              