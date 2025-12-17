class CreateStack{
    int top;
    int[] stk;
    int size;
    int s;
    CreateStack(int size){
        top = -1;
        s = 0;
        this.size = size;
        stk = new int[size];
    }
    boolean isFull(){
        return top == size - 1;
    }
    boolean isEmpty(){
        return top == -1;
    }

    void push(int data){
        if(isFull()){
            System.out.println("overflow");
            return;
        }
        if(top == -1){
            top = 0;
        }
        stk[top++] = data;
        s++;
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }
        
        top--;
        System.out.println("popped data is: "+ stk[top]);
        s--;

    }

    void display(){
        for(int i= 0;i<s;i++){
            System.out.print(stk[i]+"->");
        }
        System.out.println();
    }
}

public class practice {
    public static void main(String[] args) {
        CreateStack cs = new CreateStack(5);
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.push(5);
        cs.display();
        cs.pop();
        cs.display();
        cs.pop();
        cs.display();
    }
}
