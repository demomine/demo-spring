package com.lance.demo.spring;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by perdonare on 2017/5/11.
 */
public class TestUtil {
    @Test
    public  void createFlatXml()  throws Exception{
        // database connection
        Class driverClass = Class.forName("com.mysql.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://192.168.1.72/cloud_credit_bill", "root", "xb-12345");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        // partial database export
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        // partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL in ('t_credit_bill')");
        partialDataSet.addTable("t_credit_bill");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("src/test/resources/sql/partial.xml"));

        // full database export
      /*  IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));*/

        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
     /*   String[] depTableNames =
                TablesDependencyHelper.getAllDependentTables( connection, "t_credit_bill" );
        IDataSet depDataSet = connection.createDataSet( depTableNames );
        FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));*/
    }
}
