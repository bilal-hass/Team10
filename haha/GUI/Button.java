package GUI;

public class Button {
	private String _text;
	private Font _font;
	public int _x;
	public int _y;
	public int _width;
	public int _height;
	private boolean _show;
	public Terminal _works_in;

	public void TextLabel(String aText) {
		throw new UnsupportedOperationException();
	}

	public void Clicked() {
		throw new UnsupportedOperationException();
	}

	public String getText() {
		return this._text;
	}

	public void setText(String aText) {
		this._text = aText;
	}

	public Font getFont() {
		return this._font;
	}

	public void setFont(Font aFont) {
		this._font = aFont;
	}

	public int getX() {
		return this._x;
	}

	public void setX(int aX) {
		this._x = aX;
	}

	public int getY() {
		return this._y;
	}

	public void setY(int aY) {
		this._y = aY;
	}

	public int getWidth() {
		return this._width;
	}

	public void setWidth(int aWidth) {
		this._width = aWidth;
	}

	public int getHeight() {
		return this._height;
	}

	public void setHeight(int aHeight) {
		this._height = aHeight;
	}

	public boolean getShow() {
		return this._show;
	}

	public void setShow(boolean aShow) {
		this._show = aShow;
	}
}