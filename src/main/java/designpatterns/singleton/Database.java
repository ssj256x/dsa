package designpatterns.singleton;

public class Database {

    private volatile static Connection connection;

    private Database() {

    }

    /**
     * This method is the most naive way of achieving a singleton object. This will create multiple objects
     * when multiple threads operate on it.
     *
     * @return Connection object
     */
    public static Connection createConnectionUnsafe() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    /**
     * This method does provide thread safety but comes at a performance cost. We need to acquire a lock
     * everytime we need to just get an object.
     *
     * @return Connection object
     */
    public static synchronized Connection createConnectionSafe() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    /**
     * This method solves the above problem and uses a double check mechanism.
     * 1. It checks if the connection object is null or not, if not the current instance is returned
     * 2. If null a synchronized lock is present and it synchronizes the {@link Connection} class for thread
     * safe operations.
     * 3. A second check is present so that if another thread tried to access this object, since we are using
     * a volatile object it uses the Java Memory Management to make sure the variable is written before read
     *
     * @return Connection object
     */
    public static Connection createConnectionDoubleCheck() {
        if (connection == null) {
            synchronized (Connection.class) {
                if (connection == null) {
                    connection = new Connection();
                }
            }
        }
        return connection;
    }


    /**
     * This method ensures only one object is created at runtime and referenced everywhere
     */
    private static final Connection conn = new Connection();

    public static Connection returnEager() {
        return conn;
    }


}
