package rough;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class quardintae {
	int x;
	int y;

	public quardintae(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Try {

	static void merge(List<quardintae> list) {
		List<quardintae> merge = new ArrayList<>();
		int currentx = list.get(0).x;
		int currenty = list.get(0).y;
		Iterator<quardintae> it = list.iterator();
		
		
		while(it.hasNext())
		{
			int x=it.next().x;
			int y=it.next().y;
			if(x<currenty)
			{
				merge.add(new quardintae(currentx, y));
			}
			else
			{
				currentx=x;
				currenty=y;
				merge.add(new quardintae(currentx, currenty));
			}
		}

	}

	public static void main(String[] args) {
     List<quardintae> list= new ArrayList<quardintae>();
     list.add(new quardintae(2, 5));
     list.add(new quardintae(4, 10));
     list.add(new quardintae(11, 14));
     list.add(new quardintae(13, 20));
     merge(list);
	}
}
