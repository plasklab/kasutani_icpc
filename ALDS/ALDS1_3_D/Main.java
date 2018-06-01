import java.util.*;

class Main {
	int sumArea = 0;
	int cnt = 0;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		char[] list = new char[s.length()];
		IntegerStack slope = new IntegerStack();
		AreaStack area = new AreaStack();

		for (int i = 0; i < s.length(); i++) {
			list[i] = s.charAt(i);
		}

		for (int i = 0; i < list.length; i++) {
			//System.out.println(list[i]);
			if (list[i] == '\\') {
				slope.push(i);
			} else if (list[i] == '/') {
				int j = slope.pop();
				if (j == -1) continue;
				//System.out.println(j);
				Area a = new Area(j, i - j);
				sumArea += a.area;
				calculationArea(a, area);
			}
		}
		print(area);
	}

	void calculationArea(Area a, AreaStack area_stack) {
		/*System.out.println(a.index);
		System.out.println("cnt: " + cnt);
		cnt++;*/
		while (true) {
			Area area = area_stack.pop();
			if (area != null) {
				if (area.index > a.index) {
					a = new Area(a.index, a.area + area.area);
				} else {
					area_stack.push(area);
					area_stack.push(a);
					break;
				}
			} else {
				area_stack.push(a);
				break;
			}
			/*
			if (area_stack.size() == 0) {
				//System.out.println(a.index + " " + a.area);
				area_stack.push(a);
				//System.out.println("size:" + area_stack.size());
			}
			Area area = area_stack.pop();
			System.out.println("(" + area.index + ", " + area.area);
			if (a.index < area.index) {
				System.out.println("(" + a.index + ", " + (a.area + area.area) + ")");
				a = new Area(a.index, a.area + area.area);
				area_stack.push(a);
				//System.out.println("size:" + area_stack.size());
			} else {
				area_stack.push(area);
				area_stack.push(a);
				//System.out.println("size:" + area_stack.size());
				break;
			}
			*/
		}
	}

	void print(AreaStack area){
		System.out.println(sumArea);
		area.print();
	}
}
