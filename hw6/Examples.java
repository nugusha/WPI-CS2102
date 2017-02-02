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
            //addPage(s, "./src/PageFiles/goats.md");
            //addPage(s, "./src/PageFiles/aboutWPI.md");
        } catch (FileNotFoundException e) {
            System.out.println("Aborting Example setup -- file not found: " + e);
        } catch (UnsupportedFileExn e) {
            System.out.println("Aborting Examples setup -- unsupported file extension: " + e);
        }
    }


    @Test
    public void testGoatsQuery() {
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        assertEquals(s.runQuery("goat").size(), 2);
    }

    @Test
    public void testWPIQuery() {
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        assertEquals(s.runQuery("WPI").size(), 1);
        addPage(s, "./src/PageFiles/worcester.md");
        assertEquals(s.runQuery("WPI").size(), 2);
    }


    @Test
    public void testVisitPage() throws FileNotFoundException, UnsupportedFileExn{
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        assertTrue(s.visitPage("./src/PageFiles/goats.md").url.equals("./src/PageFiles/goats.md"));
    }

    @Test
    public void testVisitPage2() throws FileNotFoundException, UnsupportedFileExn {
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        s.runQuery("WPI");
        assertTrue(s.visitPage("./src/PageFiles/worcester.md").url.equals("./src/PageFiles/worcester.md"));
        assertEquals(s.runQuery("WPI").size(), 2);
    }

    @Test
    public void testAlreadySaw(){
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        assertFalse(s.alreadySawQuery("pizza"));
    }


    @Test
    public void testAlreadySaw2() {
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        s.runQuery("WPI");
        assertTrue(s.alreadySawQuery("WPI"));
    }

    @Test
    public void testAlreadySaw3() {
        addPage(s, "./src/PageFiles/goats.md");
        addPage(s, "./src/PageFiles/aboutWPI.md");
        s.runQuery("How is WPI");
        assertTrue(s.alreadySawQuery("What is WPI"));
    }



    //Exceptions tests

    // Testing an update that is too high and should throw an exception
    @Test(expected = InvalidRateException.class)
    public void invalidRateTest1() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 2.0);
    }

    @Test(expected = InvalidRateException.class)
    public void invalidRateTest2() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", -0.01);
    }

    // test update sponsor with no exception expected
    @Test
    public void validRateTest1() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 0.05);
    }

    @Test
    public void validRateTest2() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 0.0);
    }

    @Test
    public void validRateTest3() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", 0.1);
    }

    //tests update where new rate is lower than old rate
    @Test(expected = LowerRateException.class)
    public void lowerRateTest1() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", .05);
        s.updateSponsor("WPI", .01);
    }

    //tests update where new rate is lower than old rate
    @Test(expected = LowerRateException.class)
    public void lowerRateTest2() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", .1);
        s.updateSponsor("WPI", .09);
    }


    //tests update where new and old rates are the same
    @Test
    public void lowerRateTest3() throws LowerRateException, InvalidRateException {
        s.updateSponsor("WPI", .05);
        s.updateSponsor("WPI", .05);
    }



    //runQuery tests
    @Test
    public void runWPIQuery1(){
        LinkedList<Webpage> expectedList=new LinkedList<>();

        LinkedList<String> urls1=new LinkedList<>();
        urls1.add("goats.md");
        urls1.add("worcester.md");
        LinkedList<String> urls2=new LinkedList<>();
        urls2.add("aboutWPI.md");
        SponsorSet sponsors=new SponsorSet();
        sponsors.addSponsor("WPI", .1);
        sponsors.addSponsor("goats", .05);

        Webpage page1= new Webpage("goats.md", "caringforgoats","goatsareeasytocareforjustfeedthemgoatismascotofWPI", urls2);
        Webpage page2=new Webpage("aboutWPI.md", "articleaboutWPI", "WPIisaschoolinworcesterandhasagoatmascot",urls1);
        Webpage page3=new Webpage("worcester.md", "articleaboutworceser", "largecityinnortheastwithaschoolnamedWPI",urls2);

        page1.rank=0.55;
        page2.rank=2.1;
        page3.rank=0.5;

        expectedList.addFirst(page2);
        expectedList.add(page1);
        expectedList.add(page3);

        s.addWebpage(page1);
        s.addWebpage(page2);
        s.addWebpage(page3);

        assertTrue(s.runQuery("WPI").equals(expectedList));

    }




}
