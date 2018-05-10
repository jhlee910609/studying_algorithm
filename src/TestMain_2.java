import com.sun.prism.impl.QueuedPixelSource;

import java.util.Queue;

public class TestMain_2 {

    static String[] singers = {"소녀시대", "여자친구", "레인보우", "레드벨벳", "오마이걸", "청하", "소미"};

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedStack stack = new LinkedStack();
        LinkedQuene queue = new LinkedQuene();

        for(String temp : singers){
            stack.push(temp);
            list.insertLastNode(temp);
            queue.eneQueue(temp);
        }
//        stack.peek();
//        stack.pop();
//        stack.pop();
//        stack.peek();
//        System.out.println();
        queue.printQueue();
        queue.peek();
        queue.deQueue();
        queue.deQueue();
        queue.peek();
        queue.printQueue();




    }
}

class LinkedQuene implements Quene{

    LinkedNode rear;
    LinkedNode front;


    public LinkedQuene() {
        this.rear =null;
        this.front = null;
    }

    @Override
    public void eneQueue(String data) {
        LinkedNode newNode = new LinkedNode(data);
        if (isEmpty()){
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    public void printQueue(){
        if(isEmpty()){
            System.out.println("더 이상 출력할 데이터가 없습니다.");
        } else {
            System.out.println("Queue >>> ");
            LinkedNode temp = front;
            while (temp != null){
                System.out.println(temp.data);
                        temp = temp.link;
            }
            System.out.println();

        }
    }

    @Override
    public String deQueue() {
        if (isEmpty()){
            System.out.println("더 이상 삭제할 데이터가 없습니다.");
            return null;
        } else {
            String temp = front.data;
            front = front.link;
            if (front == null){
                rear = null;
            }
            System.out.println(temp + " 가 enQueue 되었습니다.");
            return temp;
        }
    }

    @Override
    public void delete() {
        if (isEmpty()){
            System.out.println("더 이상 삭제할 데이터가 없습니다.");
        } else {
            front = front.link;
        }
    }

    @Override
    public String peek() {
        System.out.println("peek : " + front.data);
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }
}

interface Quene{
    void eneQueue(String data);
    String  deQueue();
    void delete();
    String peek();
    boolean isEmpty();
}


class LinkedStack implements Stack{

    LinkedNode top = null;


    @Override
    public void push(String data) {
        if (top == null){
            top = new LinkedNode(data);
        } else {
            LinkedNode newNode = new LinkedNode(data);
            newNode.link = top;
            top = newNode;
        }
    }

    @Override
    public String pop() {
        if(top == null){
            return null;
        } else {
            String temp = top.data;
            top = top.link;
            return temp;
        }
    }

    @Override
    public void delete() {
        if (top == null){
            System.out.println("더 이상 삭제할 데이터가 없습니다.");
        } else {
            System.out.println(top.data+ " 를 삭제하였습니다.");
            top = top.link;
        }
    }

    @Override
    public void peek() {
        if (top == null){
            System.out.println("데이터가 없습니다.");
        } else {
            System.out.println("top : " + top.data);
        }
    }
}

interface Stack {
    void push(String data);
    String pop();
    void delete();
    void peek();

}

// linked list
class LinkedNode{
    String data;
    LinkedNode link;

    public LinkedNode(String data) {
        this.data = data;
        this.link = null;
    }
}

class LinkedList{
    LinkedNode head;

    public LinkedList() {
        head = null;
    }

    public void insertLastNode(String data) {
        if (head == null) {
            head = new LinkedNode(data);
        } else {
            LinkedNode tempNode = head;
            while (tempNode.link != null) {
                tempNode = tempNode.link;
            }
            tempNode.link = new LinkedNode(data);
        }
    }

    public void insertMiddle(LinkedNode pre, String data){
        LinkedNode newNode = new LinkedNode(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void deleteLast(){
        if(head  == null) return;
        if(head.link == null){
            head = null;
        } else {
            LinkedNode temp = head.link;
            LinkedNode pre = head;

            while(temp.link != null){
                pre = temp;
                temp = temp.link;
            }
            pre.link = null;
        }
    }

    public LinkedNode searchData(String target){
        if (head == null){
            System.out.println("검색할 데이터가 없습니다.");
        } else {
            LinkedNode temp = head;

            while (temp.link != null){
                if (temp.data.equals(target) ){
                    System.out.printf("[ %s ] 를 찾았다.\n", target);
                    return temp;
                }
                temp = temp.link;
            }
            System.out.printf("검색하신 [ %s ] 가 없습니다.\n", target);
        }
        return null;
    }

    public void printList(){
        if (head == null){
            System.out.println("출력할 데이터가 없습니다.");
        } else{
            LinkedNode temp = head;
            while (temp != null){
                System.out.print(temp.data);
                temp = temp.link;
                if(temp != null){
                    System.out.print(", ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public void reverseList(){
        LinkedNode pre, current, next;
        next = head;
        pre = new LinkedNode("");
        current = new LinkedNode("");
        while (next != null){
            System.out.println("pre : " + pre.data + ", current : " + current.data + ", next : " + next.data);
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }
        System.out.println("pre : " + pre.data + ", current : " + current.data + ", next : " + next.data);
        head = current;
        System.out.println("head : " + head.data);
    }
}