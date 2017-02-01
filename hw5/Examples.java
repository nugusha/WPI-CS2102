/*
 * If you are looking at this file before Thurs/Fri, the try/catch
 * statements won't make sense (unless you already know exceptions).
 * By Friday, we will cover those.  In the meantime, you can write
 * tests by creating your search engine classes in the Examples
 * constructor, as indicated by the comments.
 */

import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class Examples {
  // declare variables for all of your search engines here
  SearchEngine s; 
  
  // local method to add a page to a search engine.  Created a
  //   helper so that we can isolate the exception handling here,
  //   rather than clutter up each test case with the exceptions
  private void addPage(SearchEngine s, String p) {
    try {
      s.visitPage(p);
    } catch (FileNotFoundException e) {
      fail("Aborting Example setup -- file not found: " + e);
    } catch (UnsupportedFileExn e) {
      fail("Aborting Examples setup -- unsupported file extension: " + e);
    }
  }
  
  public Examples(){
    try {
      // set up all of your search engines with pages here
      // rather than in the individual tests (or you will have
      // to copy the exceptions code into the test classes)
      s = new SearchEngine(new LinkedList<String>());
      addPage(s, "PageFiles/goats.md");
      addPage(s, "PageFiles/aboutWPI.md");
    } catch (FileNotFoundException e) {
      System.out.println("Aborting Example setup -- file not found: " + e);
    } catch (UnsupportedFileExn e) {
      System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
    }
  }
  
  @Test
  public void testGoatsQuery() {
    assertEquals(s.runQuery("goat").size(), 2);
  }
  
  @Test
  public void testWPIQuery() {
    assertEquals(s.runQuery("WPI").size(), 1);
    addPage(s, "PageFiles/worcester.md");
    assertEquals(s.runQuery("WPI").size(), 2);
  }


  @Test
  public void testVisitPage() throws FileNotFoundException, UnsupportedFileExn{
      assertTrue(s.visitPage("PageFiles/goats.md").url.equals("PageFiles/goats.md"));
  }

  @Test
  public void testVisitPage2() throws FileNotFoundException, UnsupportedFileExn {
      s.runQuery("WPI");
      assertTrue(s.visitPage("PageFiles/worcester.md").url.equals("PageFiles/worcester.md"));
      assertEquals(s.runQuery("WPI").size(), 2);
  }

  @Test
  public void testAlreadySaw(){
      assertFalse(s.alreadySawQuery("pizza"));
  }


  @Test
    public void testAlreadySaw2() {
      s.runQuery("WPI");
      assertTrue(s.alreadySawQuery("WPI"));
  }

  @Test
    public void testAlreadySaw3() {
      s.runQuery("How is WPI");
      assertTrue(s.alreadySawQuery("What is WPI"));
  }



}
