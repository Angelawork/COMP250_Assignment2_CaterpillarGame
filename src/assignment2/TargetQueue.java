package assignment2;

public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> parseStr;
    public TargetQueue(){
        super();
        this.parseStr=new MyStack<String>();
    }
    public void clear(){//clears this queue and its stack field?
        parseStr.clear();
        super.clear();
    }
    public void addTargets(String input){
        String num="";
        int xCoord=0;
        int yCoord=0;

        for(int i=0;i<input.length();i++){
            char target=input.charAt(i);

            if(target=='('){
                if(num.equalsIgnoreCase("")&&parseStr.isEmpty()) {
                    if(!this.isEmpty() && input.charAt(i-1)!='.')
                        throw new IllegalArgumentException("Syntax error:no '.' in-between");
                    else if(i+1==input.length())
                        throw new IllegalArgumentException("Syntax error:'(' at end");
                    parseStr.push("(");
                }
                else{throw new IllegalArgumentException("Syntax error:'('");}
            }
            else if(target>='0'&&target<='9'){
                num=num+target;
            }
            else if(target==','){
                //check num
                if(num.equalsIgnoreCase(""))
                {throw new IllegalArgumentException("Syntax error:',' & empty num");}
                else{
                    try{int myInt=Integer.parseInt(num);}
                    catch(Exception e){throw new IllegalArgumentException("Syntax error:',' & non-int num");}
                    parseStr.push(num);
                    parseStr.push(",");
                    xCoord=Integer.parseInt(num);
                    num="";
                }
            }
            else if(target==')'){
                try {
                    String comma = parseStr.pop();
                    int myInt = Integer.parseInt(parseStr.pop());
                    String leftParen = parseStr.pop();
                    if (!(comma.equals(",") && leftParen.equals("("))) throw new IllegalArgumentException();
                }
                catch(Exception e){throw new IllegalArgumentException("Syntax error:')' & incorrect stack");}

                //check num
                if(num.equalsIgnoreCase("")){
                    throw new IllegalArgumentException("Syntax error:')' & empty num");
                } else {
                    try {
                        int myInt = Integer.parseInt(num);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Syntax error:')' & non-int num");
                    }
                    yCoord=Integer.parseInt(num);
                }

                //if correct syntax
                this.enqueue(new Position(xCoord,yCoord));
                num="";
            }
            else if(target=='.'){
                if(!(num.equalsIgnoreCase("") && parseStr.isEmpty())){
                    throw new IllegalArgumentException("Syntax error:'.' & non-empty stack,num");
                }
                if((i+1)<input.length() && input.charAt(i+1)=='.'){
                    throw new IllegalArgumentException("Syntax error:repetitive '.'");
                }
            }

            else{
                throw new IllegalArgumentException("Unknown symbol!");
            }
        }
    }
}
