package assignment2;

public class MainTester {
    public static void main(String[] a) {
        long startTime = System.nanoTime();

        /*
        MyDoublyLinkedList<Integer> tester = new MyDoublyLinkedList<Integer>();
        tester.add(1);
        tester.addFirst(0);
        MyDoublyLinkedList<Integer> tester2 = new MyDoublyLinkedList<Integer>();
        tester2.add(0);
        tester2.add(1);
        System.out.println(tester.equals(tester2));

         */
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
        /*
        MyQueue<Integer> tester=new MyQueue<>();
        tester.enqueue(0);
        tester.enqueue(1);
        tester.enqueue(2);
        tester.enqueue(3);

        MyQueue<Integer> tester2=new MyQueue<>();
        tester2.enqueue(0);
        tester2.enqueue(1);
        tester2.enqueue(2);
        tester2.enqueue(3);
        System.out.println(tester.equals(tester2));

         */
        /*
        Position test1=new Position(1,2);
        Position test2=new Position(1,2);
        System.out.println(test1.getX()+" "+test1.getY());
        System.out.println(test2.getX()+" "+test2.getY());
        System.out.println(test1.equals(test2));

         */

        TargetQueue tester1=new TargetQueue();
        tester1.addTargets("(9,9).(14,7).(10,7).(5,6).(1,9).");//empty str, str with space, single . or double ..?

        ActionQueue tester2=new ActionQueue();
        tester2.loadFromEncodedString("2[ES]1[E]2[2[E]1[N]]4[W]5[W]1[N]3[WS]1[W]");

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
        World test=new World(tester1,tester2);
        test.getCaterpillar();
        test.step();
        test.getCaterpillar();






        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000000000.0;
        System.out.println("Runtime in seconds: " + duration);
        }

    }

