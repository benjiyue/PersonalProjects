public class Vector2D implements Iterator<Integer> {
	//have a list of iterators and a current iterator
	Iterator<List<Integer>> iterators;
	Iterator<Integer> current;

	public Vector2D(List<List<Integer>> vec2d) {
		iterators = vec2d.iterator();
	}

	@Override
	public Integer next() {
		return current.next();
	}

	@Override
	public boolean hasNext() {
		//if current iterator has next or the next iterator has a next return true
		while((current==null||!current.hasNext())&&iterators.hasNext()){
			List<Integer> next = iterators.next();
			current = next!=null?next.iterator():null;
		}
		return current!=null&&current.hasNext();
	}
}