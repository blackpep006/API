package task8;

public enum Rainbow {
	VIOLET(1),
    INDIGO(2),
    BLUE(3),
    GREEN(4),
    YELLOW(5),
    ORANGE(6),
    RED(7);
	private final int color;
	private Rainbow(int value) {
		color=value;
	}
	public int getColor() {
		return color;
	}
}
