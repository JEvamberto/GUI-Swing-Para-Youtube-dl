/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youtubeDlGui.app.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
public class YoutubeDlTest {
    
    public YoutubeDlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of attach method, of class YoutubeDl.
     */
   // @Test
    public void testAttach() {
        System.out.println("attach");
        Observer observer = null;
        YoutubeDl instance = new YoutubeDl();
        instance.attach(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dettach method, of class YoutubeDl.
     */
    //@Test
    public void testDettach() {
        System.out.println("dettach");
        Observer observer = null;
        YoutubeDl instance = new YoutubeDl();
        instance.dettach(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyToAll method, of class YoutubeDl.
     */
  //  @Test
    public void testNotifyToAll() {
        System.out.println("notifyToAll");
        YoutubeDl instance = new YoutubeDl();
        instance.notifyToAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of youtubeDlBaixar method, of class YoutubeDl.
     */
    @Test
    public void testYoutubeDlBaixar() {
        System.out.println("youtubeDlBaixar");
        String qualidade = "";
        String url = "https://www.youtube.com/watch?v=6bqM9kT9f0E";
        YoutubeDl instance = new YoutubeDl();
        instance.youtubeDlBaixar(qualidade, url);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class YoutubeDl.
     */
    //@Test
    public void testGetUrl() {
        System.out.println("getUrl");
        YoutubeDl instance = new YoutubeDl();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class YoutubeDl.
     */
    //@Test
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        YoutubeDl instance = new YoutubeDl();
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQualidade method, of class YoutubeDl.
     */
   // @Test
    public void testGetQualidade() {
        System.out.println("getQualidade");
        YoutubeDl instance = new YoutubeDl();
        String expResult = "";
        String result = instance.getQualidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQualidade method, of class YoutubeDl.
     */
   // @Test
    public void testSetQualidade() {
        System.out.println("setQualidade");
        String qualidade = "";
        YoutubeDl instance = new YoutubeDl();
        instance.setQualidade(qualidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
