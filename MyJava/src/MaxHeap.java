import java.util.Arrays;

public class MaxHeap {
	
	int heap[];
	int size;

	
	public MaxHeap(int[] heap) {
		this.size=heap.length;
		this.heap = heap;;
	}
	
	public void buildMaxHeap()
	{
		for(int index=size/2-1;index>=0;index--)
			maxHeapify(index);
	}


	public void maxHeapify(int index) {
		int largest = index;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		if (leftIndex < size && heap[leftIndex] > heap[index])
			largest = leftIndex;
		if (rightIndex < size && heap[rightIndex] > heap[largest])
			largest = rightIndex;
		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest);
		}

	}

	public void swap(int index, int largest) {

		int temp=heap[index];
		heap[index]=heap[largest];
		heap[largest]=temp;
	}
	
	private void printHeap() {

		for(int i=0;i<size;i++)
		System.out.print(heap[i]+" ");
	   System.out.println();
	}
	public int findMax() {
        if (size == 0) 
            return -1;
           return heap[0];
        
    }

    public int extractMax() {
        if (size == 0) return -1;

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return min;
}
    public void insertElementIntoHeap(int element)
    {
    	heap=Arrays.copyOf(heap, size+1);
    	int index=size;
    	heap[index]=element;
    	while(index>0 && heap[index]>heap[(index-1)/2]) {
    		swap(index,(index-1)/2);
    		index=(index-1)/2;
    	}
    	
    	size++;
    }
	public static void main(String[] args) {

		MaxHeap maxHeap=new MaxHeap(new int[]{2, 4, 5, 1, 6, 7, 8});
		maxHeap.printHeap();
		maxHeap.buildMaxHeap();
		maxHeap.printHeap();
	    maxHeap.insertElementIntoHeap(100);
	    maxHeap.printHeap();
	}
//outputs:
//	2 4 5 1 6 7 8 
//	8 6 7 1 4 2 5 
//	100 8 7 6 4 2 5 1 
	

	

}
