package GUI;

import Processing.List;

public class TabbedClientArea {
	private List<Tab> _tabs;
	private Iterator<Tabs> _activeTab;
	private int _x = 0;
	private int _y = 0;
	private int _width = 800;
	private int _height = 600;
	private String _title;

	public TabbedClientArea(int aX, int aY, int aWidth, int aHeight, boolean aShow) {
		throw new UnsupportedOperationException();
	}

	public Tab createTab(Object aString_title) {
		throw new UnsupportedOperationException();
	}

	public void selectTab(Object aTab) {
		throw new UnsupportedOperationException();
	}

	public void showTab(Object aTab) {
		throw new UnsupportedOperationException();
	}
}