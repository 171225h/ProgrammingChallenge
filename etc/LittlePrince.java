package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LittlePrince {

	// 1004번 	2021.03.06.
	
	/*
	 * 두 좌표를 포함하는 원을 세면 된다!
	 * 단, 두 좌표를 동시에 포함하고 있는 점은 세지 않는다.
	 */
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int testCase = Integer.parseInt(br.readLine());

		Location start = null;
		Location arrival = null;
		Planet temp = null;
		int planetNum, x, y, r;
		Set<Planet> result = null;

		StringTokenizer st = null;


		for(int i = 0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			start = new Location(x, y);

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arrival = new Location(x, y);

			planetNum = Integer.parseInt(br.readLine());

			result = new HashSet<>();

			for(int j = 0; j<planetNum; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());

				temp = new Planet(x, y, r);

				if(temp.distance(start)==1 && temp.distance(arrival)==1) {
					continue;
				}
				else {
					if(temp.distance(start)==1)
						result.add(temp);
					if(temp.distance(arrival)==1)
						result.add(temp);
				}
			}

			bw.write(result.size()+"");
			if(i<testCase-1)
				bw.newLine();

		}

		bw.flush();
		bw.close();
	}

}

class Location{

	int x;
	int y;

	public Location(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

class Planet{
	Location location;
	int radius;

	public Planet(int x, int y, int r) {
		location = new Location(x, y);
		radius = r;
	}

	/**
	 * 점이 행성 안에 포함되면 1;
	 * 아니면 -1
	 * @param other
	 * @return
	 */
	public int distance(Location other) {
		int tempX = other.x-location.x;
		int absY = other.y-location.y;

		int dis = tempX*tempX+absY*absY;

		if(dis <= radius*radius) {
			return 1;
		}
		else
			return -1;

	}
}
