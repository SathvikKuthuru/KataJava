import java.util.ArrayList;

class Funnel {
    ArrayList<Node> num;
	StringBuilder[] line;
    public Funnel() {
    	line = new StringBuilder[5];
    	for(int i = 0; i <  5; i++) {
    		line[i] = new StringBuilder("");
    		for(int j = 5-i-1; j > 0; j--) {
    			line[i].append(" ");
    		}
    		line[i].append("\\");
    		for(int j = 0; j < (i*2)+1; j++) {
    			line[i].append(" ");
    		}
    		line[i].append("/");
    	}
    }
    
    public void fill(char...args) {  
    	num = new ArrayList<>();
    	if(num.size() == 15) return;
    	for(int i = 0; i < args.length; i++) {
    		num.add(new Node(Character.getNumericValue(args[i])));
    	}
    	int index = 0;
    	for(int i = 0; i < num.size(); i++) {
    		int b = line[index].indexOf("\\");
    		int f = line[index].indexOf("/");
    		int g = line[index].substring(b, f+1).indexOf(" ");
    		while(true) {
    			if(g == b+1 || (g+1 == f-1 && line[index].charAt((4-index)+g+1) == ' ')) {
    				System.out.println(g + " " + f);
    				break;
    			}
    			else if(line[index].charAt(f-1) == ' ') {
    				break;
    			}
    			index++;
    			b = line[index].indexOf("\\");
        		f = line[index].indexOf("/");
    			g = line[index].substring(b, f+1).indexOf(" ");
    		}
    		num.get(i).y = index;
    		num.get(i).x = (4-index) + g;
    		while(num.get(i).x != b+1 && num.get(i).x != f-1 && (line[index].charAt(num.get(i).x+1) != ' ' || line[index].charAt(num.get(i).x-1) != ' ' ||  line[index].charAt(num.get(i).x) != ' ')) num.get(i).x++;
    		line[num.get(i).y].setCharAt(num.get(i).x, Integer.toString(num.get(i).value).charAt(0));
    	}
    	this.tree();
    }
    
    public void clearFunnel() {
    	for(int i = 0; i <  5; i++) {
    		line[i] = new StringBuilder("");
    		for(int j = 5-i-1; j > 0; j--) {
    			line[i].append(" ");
    		}
    		line[i].append("\\");
    		for(int j = 0; j < (i*2)+1; j++) {
    			line[i].append(" ");
    		}
    		line[i].append("/");
    	}
    }
    
    public void refill() {
    	this.clearFunnel();
    	for(int i = 0; i < num.size(); i++) {
    		line[num.get(i).y].setCharAt(num.get(i).x, Integer.toString(num.get(i).value).charAt(0));
    		System.out.println(num.get(i).y);
    	}
    	this.tree();
    }
    
    public int find(int x, int y) {
    	for(int j = 0; j < num.size(); j++) {
			if(num.get(j).x == x && num.get(j).y == y) {	
				return j;
			}
		}
    	return num.size()-1;
    }
    
    public void tree() {
    	for(int i = 0; i < num.size(); i++) {
    		Node n = num.get(i);
    		if(n.y == 4) return;
    		int x1 = n.x+1, x2 = n.x-1;
    		int y = n.y+1;
    		if(line[y].charAt(x1) != ' ' && line[y].charAt(x1) != '/') {
    			num.get(i).right = num.get(find(x1, y));
    		}
    		if(line[y].charAt(x2) != ' ' && line[y].charAt(x1) != '\\') {
    			num.get(i).left = num.get(find(x2, y));
    		}
    	}
    }
    
    public boolean isTrue(boolean[] v) {
    	for(int i = 0; i < v.length; i++) if(!v[i]) return false;
    	return true;
    }
    
	public Character drip() {
		if (num.size() == 0) return null;
		Character c = Integer.toString(num.get(0).value).charAt(0);
		boolean a = false;
		Node n;
		if(this.weight(num.get(0).right) > this.weight(num.get(0).left)) {
			n = num.get(0).right;
			a = true;
		} else n = num.get(0).left;
		int x = 0;
		Node last = null;
		while(n != null) {
			num.set(x, num.get(find(n.x, n.y)));
			num.get(x).x += a ? -1 : 1;
			num.get(x).y--;
			
			if((num.get(x).right == null || Integer.toString(num.get(x).right.value).charAt(0) == ' ' || Integer.toString(num.get(x).right.value).charAt(0) == '\\') &&
					(num.get(x).left == null || Integer.toString(num.get(x).left.value).charAt(0) == ' ' || Integer.toString(num.get(x).left.value).charAt(0) == '/')) 
			{
				break;
			}
			int temp = x;
			x = find(n.x, n.y);
			if(this.weight(num.get(temp).right) > this.weight(num.get(temp).left)) {
				n = num.get(temp).right;
				a = true;
			} else {
				n = num.get(temp).left;
				a = false;
			}
		
		}
		//if(find(last.x-1, last.y) != -1) num.remove(find(last.x-1, last.y));
		//else num.remove(find(last.x+1, last.y));
		this.refill();
		return c;
	}
    
    public int weight(Node n) {
    	if(n == null || Integer.toString(n.value).charAt(0) == ' ' || Integer.toString(n.value).charAt(0) == '\\' || Integer.toString(n.value).charAt(0) == '/') return 0;
    	return 1 + weight(n.left) + weight(n.right);
    }
    
    public String toString() { 
        String s = "";
        for(int i = line.length-1; i >= 0; i--) {
        	s += line[i].toString();
        	if(i != 0) s += "\n";
        }
        return s;
    }
    
    public static void main(String[] args) {
    	Funnel funnel = new Funnel();
    	funnel.fill('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1');
    	System.out.println(funnel.toString());
    	/*funnel.drip();
    	System.out.println(funnel.toString());*/
    	for(Node n : funnel.num) {
    		System.out.println("Node " + n.value + " x: " + n.x + " y: " + n.y);
    	}
    }
    
    static class Node {
    	int value;
    	int x, y;
    	Node left, right;
    	
    	public Node(int v) {
    		value = v;
    		left = null;
    		right = null;
    	}
    }

}
