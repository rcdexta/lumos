package ds.stack;

public class MinStack extends Stack<Integer> {

    private Stack<Integer> minElements;

    public MinStack() {
        super();
        minElements = new Stack<>();
    }

    @Override
    public Integer pop() throws StackEmptyException {
        Integer element = super.pop();
        if (element.equals(recentMinElement())) {
            minElements.pop();
        }
        return element;
    }

    @Override
    public void push(Integer newElement) {
        super.push(newElement);
        if (minElements.isEmpty() || this.recentMinElement() >= newElement) {
            minElements.push(newElement);
        }
    }

    public Integer min() throws StackEmptyException {
        return minElements.peek();
    }

    private Integer recentMinElement() {
        try {
            return minElements.peek();
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
        return Integer.MIN_VALUE;
    }


}
