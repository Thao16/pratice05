import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common Test Cases/Login to NewBorn'), [('username') : 'superadmin', ('password') : 'Newborns@123'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/opt_UserManagement'))

WebUI.click(findTestObject('UserManagement/btn_addNewUser'))

WebUI.setText(findTestObject('UserManagement/Add New User/txt_Username'), CustomKeywords.'random.RandomString.createRandomString'())

WebUI.delay(2)

randomstring = WebUI.getAttribute(findTestObject('UserManagement/Add New User/txt_Username'), 'value')

System.out.println(randomstring)

WebUI.setText(findTestObject('Object Repository/UserManagement/Add New User/txt_Email'), randomstring + '@yopmail.com')

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/dpl_Role'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/opt_Hospital Admin'))

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/dpl_Manage'))

WebUI.click(findTestObject('UserManagement/Add New User/opt_DaNangHospital'))

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/span_OK'))

WebUI.delay(2)

newusername = WebUI.getText(findTestObject('UserManagement/Add New User/lbl_userName'))

newpassword = WebUI.getText(findTestObject('UserManagement/Add New User/lbl_password'))

WebUI.click(findTestObject('Object Repository/UserManagement/Add New User/span_ok (1)'))

WebUI.callTestCase(findTestCase('Common Test Cases/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common Test Cases/Login to NewBorn'), [('password') : newpassword, ('username') : newusername], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

