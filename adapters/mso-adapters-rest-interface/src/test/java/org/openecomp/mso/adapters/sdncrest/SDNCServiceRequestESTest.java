/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 20 14:08:11 GMT 2017
 */

package org.openecomp.mso.adapters.sdncrest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, useJEE = true)
public class SDNCServiceRequestESTest extends SDNCServiceRequestESTestscaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      ServiceInformation serviceInformation0 = mock(ServiceInformation.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(serviceInformation0).toString();
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest("org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", "org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", "", "{", "org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", requestInformation0, serviceInformation0, "6`.", "{");
      sDNCServiceRequest0.getServiceInformation();
      assertEquals("{", sDNCServiceRequest0.getSDNCService());
      assertEquals("{", sDNCServiceRequest0.getSDNCServiceData());
      assertEquals("org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", sDNCServiceRequest0.getSDNCOperation());
      assertEquals("6`.", sDNCServiceRequest0.getSDNCServiceDataType());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      sDNCServiceRequest0.setSDNCServiceDataType("2u]\"aLx");
      String string0 = sDNCServiceRequest0.getSDNCServiceDataType();
      assertEquals("2u]\"aLx", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      sDNCServiceRequest0.setSDNCServiceData("}=uO{e7dUj.<");
      String string0 = sDNCServiceRequest0.getSDNCServiceData();
      assertEquals("}=uO{e7dUj.<", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      sDNCServiceRequest0.setSDNCServiceData("");
      String string0 = sDNCServiceRequest0.getSDNCServiceData();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      ServiceInformation serviceInformation0 = mock(ServiceInformation.class, new ViolatedAssumptionAnswer());
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest("STATIC", "STATIC", "", "", "STATIC", requestInformation0, serviceInformation0, "STATIC", "+VFyyH0:WXAf=Y+|K");
      String string0 = sDNCServiceRequest0.getSDNCService();
      assertEquals("", string0);
      assertEquals("STATIC", sDNCServiceRequest0.getSDNCServiceDataType());
      assertEquals("STATIC", sDNCServiceRequest0.getSDNCOperation());
      assertEquals("+VFyyH0:WXAf=Y+|K", sDNCServiceRequest0.getSDNCServiceData());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      String string0 = sDNCServiceRequest0.getSDNCOperation();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      sDNCServiceRequest0.setSDNCOperation("");
      String string0 = sDNCServiceRequest0.getSDNCOperation();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(requestInformation0).toString();
      sDNCServiceRequest0.setRequestInformation(requestInformation0);
      RequestInformation requestInformation1 = sDNCServiceRequest0.getRequestInformation();
      assertSame(requestInformation1, requestInformation0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      String string0 = sDNCServiceRequest0.getSDNCServiceDataType();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      String string0 = sDNCServiceRequest0.getSDNCService();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      ServiceInformation serviceInformation0 = mock(ServiceInformation.class, new ViolatedAssumptionAnswer());
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest("STATIC", "STATIC", "", "", "STATIC", requestInformation0, serviceInformation0, "STATIC", "+VFyyH0:WXAf=Y+|K");
      String string0 = sDNCServiceRequest0.getSDNCOperation();
      assertEquals("", sDNCServiceRequest0.getSDNCService());
      assertEquals("+VFyyH0:WXAf=Y+|K", sDNCServiceRequest0.getSDNCServiceData());
      assertEquals("STATIC", string0);
      assertEquals("STATIC", sDNCServiceRequest0.getSDNCServiceDataType());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      ServiceInformation serviceInformation0 = sDNCServiceRequest0.getServiceInformation();
      assertNull(serviceInformation0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      RequestInformation requestInformation0 = sDNCServiceRequest0.getRequestInformation();
      assertNull(requestInformation0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      ServiceInformation serviceInformation0 = mock(ServiceInformation.class, new ViolatedAssumptionAnswer());
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest("33M*~O'k?", "33M*~O'k?", "33M*~O'k?", "33M*~O'k?", "33M*~O'k?", requestInformation0, serviceInformation0, "33M*~O'k?", "[t[");
      sDNCServiceRequest0.setServiceInformation((ServiceInformation) null);
      assertEquals("33M*~O'k?", sDNCServiceRequest0.getSDNCService());
      assertEquals("[t[", sDNCServiceRequest0.getSDNCServiceData());
      assertEquals("33M*~O'k?", sDNCServiceRequest0.getSDNCOperation());
      assertEquals("33M*~O'k?", sDNCServiceRequest0.getSDNCServiceDataType());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      RequestInformation requestInformation0 = mock(RequestInformation.class, new ViolatedAssumptionAnswer());
      ServiceInformation serviceInformation0 = mock(ServiceInformation.class, new ViolatedAssumptionAnswer());
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest("", "M6Oxa*g8~:)0BdUFX/", "org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", "M6Oxa*g8~:)0BdUFX/", "org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", requestInformation0, serviceInformation0, "", "TWqSFP>PXW");
      String string0 = sDNCServiceRequest0.getSDNCServiceDataType();
      assertEquals("org.openecomp.mso.adapters.sdncrest.SDNCServiceRequest", sDNCServiceRequest0.getSDNCOperation());
      assertEquals("TWqSFP>PXW", sDNCServiceRequest0.getSDNCServiceData());
      assertEquals("", string0);
      assertEquals("M6Oxa*g8~:)0BdUFX/", sDNCServiceRequest0.getSDNCService());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      String string0 = sDNCServiceRequest0.getSDNCServiceData();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      SDNCServiceRequest sDNCServiceRequest0 = new SDNCServiceRequest();
      sDNCServiceRequest0.setSDNCService("-3eOw~BRI3K>O");
      String string0 = sDNCServiceRequest0.getSDNCService();
      assertEquals("-3eOw~BRI3K>O", string0);
  }
}