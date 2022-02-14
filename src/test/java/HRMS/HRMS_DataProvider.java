package HRMS;

import org.testng.annotations.DataProvider;

public class HRMS_DataProvider
{
    // Data Provider for Positive 
    @DataProvider(name = "LoginScenario")
    public Object[][] getDataforLoginDifferentScenarios()
    {
      return new Object[][]
                {
                    { "rohit.ghadge@vinsys.com", "H$sv2g", "Hrms" },
                    //{ "", "admin123", "Username cannot be empty" },
                    //{ "AdminWrong", "admin123", "Invalid credentials" },
                    //{ "admin", "admin", "Invalid credentials" },
                    //{ "admin", "admin123", "Dashboard" }
                };

    }

    // Data Provider for Negative
    @DataProvider(name = "LoginScenario2")
    public Object[][] getDataforLoginDifferentScenarios2()
    {
      return new Object[][]
                {
                    { "", "admin123", "Username cannot be empty" },
                    { "rohit.ghadge@vinsys.com", "Hv2g", "Wrong Pass" },
                    { "AdminWrong", "admin123", "Invalid credentials" },
                    { "admin", "admin", "Invalid credentials" },
                    { "admin", "admin123", "Dashboard" }
                };

    }

}