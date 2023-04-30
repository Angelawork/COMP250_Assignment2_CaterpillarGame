package assignment2;

import java.util.ArrayList;

public class MainTester {
    public static void main(String[] a) {
        long startTime = System.nanoTime();


        MyDoublyLinkedList<Integer> DLLtester = new MyDoublyLinkedList<Integer>();
        DLLtester.add(null);
        DLLtester.add(null);
        MyDoublyLinkedList<String> DLLtester2 = new MyDoublyLinkedList<String>();
        DLLtester2.add(null);
        System.out.println(DLLtester.equals(DLLtester2));
        System.out.println("________________");

        /*
        MyStack<Integer> tester = new MyStack<Integer>();

        tester.push(0);
        tester.push(1);
        tester.push(2);
        tester.push(3);
        tester.push(4);
        System.out.println(tester.isEmpty());
        System.out.println(tester.peek());

         */

        MyQueue<String> tester=new MyQueue<>();
        tester.clear();
        MyQueue<Integer> tester2=new MyQueue<>();
        tester2.enqueue(0);
        tester2.enqueue(1);
        tester2.enqueue(2);
        tester2.enqueue(3);
        tester2.clear();
        System.out.println(tester.equals(tester2));


        /*/
        MyQueue<Integer> tester1=new MyQueue<Integer>();
        MyQueue<Integer> tester0=new MyQueue<Integer>();
        MyQueue<String> tester2=new MyQueue<String>();
        tester2.enqueue("1");
        tester2.enqueue(null);
        tester2.enqueue("45");
        MyQueue<String> tester3=new MyQueue<String>();
        tester3.enqueue("1");
        tester3.enqueue(null);
        tester3.enqueue("45");
        System.out.println(tester0.equals(tester1));
        System.out.println(tester2.equals(tester1));
        */
        /*
        Position test1=new Position(1,2);
        Position test2=new Position(1,2);
        System.out.println(test1.getX()+" "+test1.getY());
        System.out.println(test2.getX()+" "+test2.getY());
        System.out.println(test1.equals(test2));

         */

            TargetQueue test = new TargetQueue();
            test.addTargets("");
            test.addTargets("(9,5019).(31074,11)");

            boolean exceptionThrown;

            ArrayList<String> inputs = new ArrayList<>();
        test.addTargets("");                             // empty string
        test.addTargets("(9,5019).(31074,11)");          // correct input
        test.addTargets("(1,19).(4,901)");               // correct input
        test.addTargets("(1,8129).(4,1).(31,3)");        // correct input
        test.addTargets("(11,9).(2084,31).(1,31931)");   // correct input
        test.addTargets("(1,319).(4112,221).(381,853)"); // correct input

        for (String input : inputs) {
             //test.addTargets(input);
         }

/*
    String sTest1Valid = "(1,2).(2,4)";
    String sTest2Valid = "(1,2).(2,4).(3,5)";
    String sTest3ExtraNum = "(1,2).(2,4,5)";
    String sTest4ExtraComma = "(1,,2).(2,4)";
    String sTest5ExtraParen = "(1,2)).(2,4)";
    String sTest6ExtraParen = "((1,2).(2,4)";
    String sTest7ExtraParen = ")1,2).(2,4)";
    String sTest8ExtraDot = "(1,2)..(2,4)";
    String sTest9ExtraDot = ".(1,2).(2,4)"; //this should work?
    String sTest10ExtraChar = "(1,2).(2,4)i";
    String sTest11ExtraChar= "(1,i2).(2,4)";
    String sTest12ExtraDot = "t";
    String sTest13MissComma = "(1 2).(2,4)";
    String sTest14MissDot = "(12)(2,4)";
    String sTest15MissNum= "(12).(2,4)";
    String sTest16MissParen= "(12,3.(2,4)";
    String sTest18MissParen= "(12,3).(2,4";
    String sTest19MissParen= "12,3).(2,4)";
    String sTest20Valid= "(12,3)";
    String sTest21Valid= "(12233,1233)";
    String sTest22Valid= "(12233,1233).(12233,1233).(12233,1233).(12233,1233).(12233,1233)";
 */
        /*
        Region tester=new Region(0,3,5,6);
        Position test1=new Position(0,4);
        System.out.println(tester.contains(test1));
        Position test2=new Position(10,11);
        System.out.println(tester.contains(test2));

         */
        /*
        Caterpillar test=new Caterpillar();
        test.eat(new Position(8,7));
        System.out.println(test.selfCollision(new Position(7,7)));

        */
        /*
        World test=new World(tester1,tester2);
        test.getCaterpillar();
        test.step();
        test.getCaterpillar();

         */


        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000000000.0;
        System.out.println("Runtime in seconds: " + duration);
    }
}


