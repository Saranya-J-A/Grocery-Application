package constant;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryTestData.xlsx";
public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";	
public static final String VALIDANDINVALIDERROR="User is able to login with correct username and incorrect password";
public static final String INVALIDANDVALIDERROR="User is able to login with incorrect username and correct password";
public static final String VALIDCREDENTIALSERROR2="User is able to login with invalid credentials";
public static final String HOMETESTERROR="User is unable to logout";
public static final String ADMINUSERSNEWUSERADDERROR="User Is unable to add admin users list";
public static final String ADMINUSERSEARCHADDEDUSERERROR="User is noeable to search the added items";
public static final String ADDNEWCATEGORYERROR="User is not able to add new category";
public static final String SEARCHADDEDCATEGORYERROR="The User is not able to search listcategories";
}
