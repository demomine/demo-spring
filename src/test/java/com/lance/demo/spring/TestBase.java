package com.lance.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;

/**
 * Created by perdonare on 2017/5/11.
 */
@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {App.class})
public class TestBase {
}
