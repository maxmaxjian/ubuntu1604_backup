
class Position {
    public int x1;
    public int x2;

    public Position(int xval, int yval) {
	x1 = xval;
	x2 = yval;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("(");
	sb.append(x1);
	sb.append(", ");
	sb.append(x2);
	sb.append(")");
	return sb.toString();
    }
}
