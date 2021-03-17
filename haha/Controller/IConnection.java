package Controller;

public interface IConnection {

	public Connection connect(String aSql);

	public Boolean disconnect(Connection aConn);
}