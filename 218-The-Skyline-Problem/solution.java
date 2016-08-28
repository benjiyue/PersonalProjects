public class Solution {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new LinkedList();
		if(buildings==null||buildings.length==0)
			return res;

		List<int[]> sorted = new ArrayList<int[]>();

		for(int i=0;i<buildings.length;i++){
			sorted.add(new int[]{buildings[i][0], -buildings[i][2]});
			sorted.add(new int[]{buildings[i][1], buildings[i][2]});
		}

		sorted.sort(new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				//x coordiantes are different
				if(a[0]!=b[0])
					return a[0]-b[0];
				
				//x coordinates are the same
				//both are start, return the smaller, higher - val as lower
				if(a[1]<0&&b[1]<0){
					return a[1]-b[1];
				}
				//only one is start, return the start
				else if(a[1]<0||b[1]<0)
					return a[1]<0?-1:1;
				//both are end 
				else
					return a[1]-b[1];
			}
		});

		//0 = x pos, 1 = height, - if neginning, + if end
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(buildings.length*2, Collections.reverseOrder());		pq.add(0);
		for(int[] i:sorted){
			//it's a beginning
			if(i[1]<0){
				if(i[1]*-1>pq.peek())
					res.add(new int[]{i[0], -1*i[1]});
				pq.offer(i[1]*-1);
			}
			else{
				pq.remove(i[1]);
				if(pq.peek()<i[1]){
					res.add(new int[]{i[0], pq.peek()});
				}

			}
		}
		return res;
	}

}