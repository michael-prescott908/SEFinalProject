package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import Table.Database;
import Table.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ITSTest {

    /**
     * Class: TestDatabase
     *  Checks if any exception is thrown
     */
    @Test
    public void TestDatabase(){
        Connection con = Database.connect();
        String[] strArr = {
                "123.43",
                "Shoes",
                "982347524"
        };
        Database.insert(strArr, con);
        Database.remove(Integer.parseInt(strArr[2]), con);
    }
}
