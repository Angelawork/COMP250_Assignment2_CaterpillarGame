package assignment2;

public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> words;
    private MyStack<Integer> counts;
    public ActionQueue(){
        super();
        this.words=new MyStack<String>();
        this.counts=new MyStack<Integer>();
    }
    public void clear(){
        words.clear();
        counts.clear();
        super.clear();
    }
    public void loadFromEncodedString(String input){
        String num="";
        String letter="";

        if(input.equals(""))return;

        //if(input.charAt(input.length()-1)!=']'){throw new IllegalArgumentException("Not proper ending!");}

        for(int i=0;i<input.length();i++){
            char target=input.charAt(i);
            if(target=='N'||target=='S'||target=='E'||target=='W'){
                letter=letter+target;
            }
            else if(target>='0'&&target<='9'){
                /*detect 2[N1[E]] ?
                if((i-1)>=0){
                    char temp=input.charAt(i-1);
                    if(!(temp>='0' && temp<='9') && !(temp=='[' || temp==']')) //if not a number and not []
                        throw new IllegalArgumentException("Syntax error:letter with num DK[D]");
                }
                 */
                num=num+target;
            }

            else if(target=='['){
                if(num.equalsIgnoreCase(""))
                {throw new IllegalArgumentException("Syntax error:'[' & empty num");}
                else {
                    try {
                        int myInt = Integer.parseInt(num);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Syntax error:'[' & non-int num");
                    }
                }
                if((i-1)>=0){
                    char temp=input.charAt(i-1);
                    if(!(temp>='0' && temp<='9'))throw new IllegalArgumentException("Syntax error:letter before num");
                }

                counts.push(Integer.parseInt(num));
                words.push(letter);

                //reset
                letter="";
                num="";
            }else if(target==']'){
                if(words.isEmpty()){throw new IllegalArgumentException("Syntax error:']' missing '['");}
                if(counts.isEmpty()){throw new IllegalArgumentException("Syntax error:']' missing K");}
                if(letter.equals("")){throw new IllegalArgumentException("Syntax error:']' missing D");}
                int times = counts.pop();
                letter=letter.repeat(times);
                letter=words.pop()+letter;
            }
            else{
                throw new IllegalArgumentException("Unknown symbol!");
            }
        }

        if(!words.isEmpty()){throw new IllegalArgumentException("Syntax error:missing closing ']'");}

        //assign
        for(int j=0;j<letter.length();j++){
            char elmt=letter.charAt(j);
            switch (elmt) {
                case 'N':
                    this.enqueue(Direction.NORTH);
                    break;
                case 'S':
                    this.enqueue(Direction.SOUTH);
                    break;
                case 'W':
                    this.enqueue(Direction.WEST);
                    break;
                case 'E':
                    this.enqueue(Direction.EAST);
                    break;
            }
        }

    }
}
