package com.lahtinen.jaakko.Bookstore;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BookRepositoryTest.class, BookstoreApplicationTests.class, UserRepositoryTest.class,
		WebLayerTest.class })
public class AllTests {

}
