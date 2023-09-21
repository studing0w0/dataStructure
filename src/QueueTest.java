import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/*
    FIFO, Queue는 앞뒤로 주소를 알고 있어야함
 */
class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item){
        Node<T> t = new Node<T>(item);
        // 마지막 노드가 있다면 그 뒤에 새로 생성
        if(last != null){
            last.next = t;
        }
        last = t;
        // 데이터가 없을 때는
        if(first == null){
            first = last; // 마지막과 같은 값 할당
        }

    }

    public T remove(){
        if(first == null){
            throw new NoSuchElementException();
        }
        T data = first.data; // 데이터 백업 후
        first = first.next; // first로 만들어주기
        if(first == null) last = null;
        return data;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }
}
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.remove());


    }
}
