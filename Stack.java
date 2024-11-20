import java.util.NoSuchElementException;

public class Stack<T> {
	private T[] data;
	private int size;

	public Stack(int capacity) {
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public void push(T element) {
		if (size == data.length) {
			throw new StackOverflowError("Stack overflow");
		}
		data[size++] = element;
	}

	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException("Stack empty");
		}
		T element = data[--size];
		data[size] = null; // освобождаем ссылку
		return element;
	}

	public T peek() {
		if (size == 0) {
			throw new NoSuchElementException("Stack empty");
		}
		return data[size - 1];
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop()); // 3
		System.out.println(stack.peek()); // 2
		stack.push(4);
		System.out.println(stack.pop()); // 4
	}
}
