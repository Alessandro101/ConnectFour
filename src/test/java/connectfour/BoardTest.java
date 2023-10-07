package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest{
    private Board tester;

    @Before
    public void setup(){
        //set up for the test
        tester = new Board();

    }

    @Test 
    public void testcheckVerticalWin(){
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckVerticalWin2(){
        tester.changeBoard(7,'2');
        tester.changeBoard(7,'2');
        tester.changeBoard(7,'2');
        tester.changeBoard(7,'2');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckVerticalWin3(){
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckVerticalWin4(){
        tester.changeBoard(5,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckHorizontalWin(){
        tester.changeBoard(1,'1');
        tester.changeBoard(2,'1');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckHorizontalWin2(){
        tester.changeBoard(2,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'2');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckHorizontalWin3(){
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'1');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'1');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckHorizontalWin4(){
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckDiagonalWin(){
        tester.changeBoard(1,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(2,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(4,'1');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(4,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckDiagonalWin2(){
        tester.changeBoard(7,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(6,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(4,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckDiagonalWin3(){
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'2');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(7,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(7,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testcheckDiagonalWin4(){
        tester.changeBoard(4,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(4,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(1,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(1,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        Assert.assertTrue(tester.checkWin());
    }
    @Test
    public void testchangeBoard(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0"); 
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        Assert.assertEquals(tester.toString(),string.toString());
    }
    @Test
    public void testcheckLoadedBoard(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0"); 
        tester.setLoadedBoard(string);
        Exception ex = null;
        try{
            tester.checkLoadedBoard();
        }catch(Exception e){
            ex = e;
        }
        Assert.assertNull(ex);
    }
    @Test
    public void testcheckLoadedBoardException(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\n1,0,0,0,0,0,"); 
        tester.setLoadedBoard(string);
        Exception ex = null;
        try{
            tester.checkLoadedBoard();
        }catch(Exception e){
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
    @Test
    public void testcheckLoadedBoardException2(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\nA,0,0,0,0,0,0"); 
        tester.setLoadedBoard(string);
        Exception ex = null;
        try{
            tester.checkLoadedBoard();
        }catch(Exception e){
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
    @Test
    public void testcheckLoadedBoardException3(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\n0,0,0,0,0,0,0"); 
        tester.setLoadedBoard(string);
        Exception ex = null;
        try{
            tester.checkLoadedBoard();
        }catch(Exception e){
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
    @Test
    public void testcheckLoadedBoardException4(){
        StringBuilder string = new StringBuilder("1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0");
        string.append("\n1,0,0,0,0,0,0\n1,0,0,0,0,0,0\n"); 
        tester.setLoadedBoard(string);
        Exception ex = null;
        try{
            tester.checkLoadedBoard();
        }catch(Exception e){
            ex = e;
        }
        Assert.assertNotNull(ex);
    }
    @Test
    public void testcheckTie(){
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'2');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'2');
        Assert.assertTrue(tester.checkTie());
    }
    @Test
    public void testcheckTie2(){
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(1,'1');
        tester.changeBoard(1,'2');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(2,'1');
        tester.changeBoard(2,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'2');
        tester.changeBoard(3,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'1');
        tester.changeBoard(4,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'1');
        tester.changeBoard(5,'2');
        tester.changeBoard(5,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(6,'2');
        tester.changeBoard(6,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'1');
        tester.changeBoard(7,'2');
        tester.changeBoard(7,'1');
        Assert.assertFalse(tester.checkTie());
    }
}