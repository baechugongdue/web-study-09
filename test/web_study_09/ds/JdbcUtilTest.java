package web_study_09.ds;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JdbcUtilTest {

    @Test
    public void testGetConnection() {
        Connection con = JdbcUtil.getConnection();
        Assert.assertNotNull(con);
        System.out.println("con : " + con);
    }

}
