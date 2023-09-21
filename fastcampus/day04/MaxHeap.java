package day04;

public class MaxHeap {
	private int[] heap;
	private int size;

	public MaxHeap(int length) {
		heap = new int[length];
		heap[0] = Integer.MAX_VALUE;
		this.size = 0;
	}

	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(100);
		// 왼쪽 자식-> idx*2
		// 오른쪽 자식 -> idx*2+1

		mh.insert(10);
		mh.insert(5);
		mh.insert(8);
		mh.insert(15);
		mh.insert(3);
		mh.insert(12);

		for (int i = 1; i <= mh.size; i++) {
			System.out.print(mh.heap[i] + " ");
		}
		System.out.println();
		mh.insert(20);
		for (int i = 1; i <= mh.size; i++) {
			System.out.print(mh.heap[i] + " ");
		}
		System.out.println();
	}

	public void insert(int num) {
		heap[++size] = num;
		upHeap(size);
	}

	private void upHeap(int pos) {
		int tmp = heap[pos];// 자기 자리를 찾아서 들어갈 값
		while (heap[pos / 2] < tmp) {// head[pos/2] 부모 노드
			heap[pos] = heap[pos / 2];
			pos /= 2;
		}
		heap[pos] = tmp;
	}
}
