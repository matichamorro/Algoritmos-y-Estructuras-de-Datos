package tp1.ejercicio8;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		System.out.println(q);
		System.out.println(q.size());
		System.out.println(q.isEmpty());
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		System.out.println(q);
		System.out.println(q.dequeue());
		System.out.println(q.head());
		
		System.out.println();
		CircularQueue<Integer> cq = new CircularQueue<Integer>();
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		System.out.println(cq);
		System.out.println(cq.shift());
		System.out.println(cq);
		
		System.out.println();
		DoubleEndedQueue<Integer> dq = new DoubleEndedQueue<Integer>();
		dq.enqueue(12);
		dq.enqueue(15);
		dq.enqueue(18);
		System.out.println(dq.dequeue());
		dq.enqueueFirst(8);
		dq.enqueue(20);
		dq.enqueueFirst(3);
		System.out.println(dq);
		
	}

}
