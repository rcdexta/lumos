package ds.stacks;

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
    public void push(Integer item) {
        super.push(item);
        if (minElements.isEmpty() || this.recentMinElement() >= item) {
            minElements.push(item);
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
